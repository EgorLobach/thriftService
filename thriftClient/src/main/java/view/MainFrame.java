package view;

import aipos.model.Author;
import aipos.model.Chapter;
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
        JButton updateButton = new JButton("Обновить статью");
        updateButton.addActionListener(e -> updateItem());
        buttonPanel.add(updateButton);

        JButton addItemButton = new JButton("Добавить статью");
        addItemButton.addActionListener(e -> {addItem();});
        buttonPanel.add(addItemButton);

        JButton deleteItemButton = new JButton("Удалить статью");
        deleteItemButton.addActionListener(e -> {deleteItem();});
        buttonPanel.add(deleteItemButton);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }


    private void update() {
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
        clientController.updateItem(item);
    }

    private void addItem(){
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter("FirstChapter", ""));
        Item item = new Item("New", 0, new Author("",""), chapters);
        clientController.addItem(item);
        update();

    }

    private void deleteItem() {
        ItemPanel itemPanel = itemPanels.get(tabbedPane.getSelectedIndex());
        clientController.deleteItem(itemPanel.getName());
        update();

    }
}
