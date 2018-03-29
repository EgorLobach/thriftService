package view;

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
        JPanel buttonPanel = new JPanel();

        JButton updateButton = new JButton("Обновить справочник");
        updateButton.addActionListener(e -> update());
        buttonPanel.add(updateButton);

        JButton addItemButton = new JButton("Добавить статью");
        addItemButton.addActionListener(e -> addItem());
        buttonPanel.add(addItemButton);

        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }


    void update() {
        tabbedPane.removeAll();
        for (Item item : clientController.getItems()) {
            itemPanels.add(new ItemPanel(item, clientController, this));
            tabbedPane.add(itemPanels.get(itemPanels.size() - 1).getName(), itemPanels.get(itemPanels.size() - 1).getPanel());
        }
        mainFrame.validate();
        mainFrame.repaint();
    }

    private void addItem() {
        new AddItemDialog(clientController);
        update();
    }

}
