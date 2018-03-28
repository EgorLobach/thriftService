package view;

import aipos.model.Author;
import aipos.model.Item;
import controller.ClientController;
import org.apache.thrift.TException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame {

    static Font MAIN_FONT = new Font("", Font.ITALIC, 17);

    private ClientController clientController;

    private JFrame mainFrame;
    private JTabbedPane tabbedPane;
    private List<ItemPanel> itemPanels;

    public MainFrame(ClientController clientController) throws TException {
        itemPanels = new ArrayList<>();
        this.clientController = clientController;
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(MAIN_FONT);
        mainFrame = new JFrame("Thrift Client");
        mainFrame.setSize(new Dimension(1440, 900));
        mainFrame.setPreferredSize(mainFrame.getSize());
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
    }

    private void init() throws TException {
        update();
        mainFrame.add(tabbedPane, BorderLayout.CENTER);
        JButton updateButton = new JButton("Обносвить статью");
        updateButton.addActionListener(e -> updateItem());
        mainFrame.add(updateButton, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }
    private void update() throws TException {
        tabbedPane.removeAll();
        for(Item item : clientController.getItems()){
            itemPanels.add(new ItemPanel(item));
            tabbedPane.add(itemPanels.get(itemPanels.size()-1).getName(),itemPanels.get(itemPanels.size()-1).getPanel());
        }
        mainFrame.validate();
        mainFrame.repaint();
    }

    private void updateItem(){
        ItemPanel itemPanel = itemPanels.get(tabbedPane.getSelectedIndex());
        Item item = new Item(itemPanel.getName(),
                Integer.parseInt(itemPanel.getYearOfPublication().getText()),
                itemPanel.getAuthor(), itemPanel.getChapterPanel().getChapters());
        try {
            clientController.updateItem(item);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
