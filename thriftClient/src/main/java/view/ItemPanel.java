package view;

import aipos.model.Author;
import aipos.model.Chapter;
import aipos.model.Item;
import controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static view.MainFrame.MAIN_FONT;

public class ItemPanel {

    private ClientController clientController;
    private String name;
    private JPanel itemPanel;

    private JLabel authorLabel = new JLabel("Автор:");
    private JTextField authorFirstName;
    private JTextField authorSecondName;
    private JLabel yearOfPublicationLabel = new JLabel("Год публикации");
    private JTextField yearOfPublication;
    private MainFrame mainFrame;

    private List<ChapterPanel> chapterPanels;

    ItemPanel(Item item, ClientController clientController, MainFrame mainFrame){
        this.clientController=clientController;
        this.mainFrame = mainFrame;
        itemPanel = new JPanel();
        name = item.name;
        chapterPanels = new ArrayList<>();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(MAIN_FONT);

        authorFirstName = new JTextField(item.author.firstName);
        authorSecondName = new JTextField(item.author.secondName);
        authorFirstName.setPreferredSize(new Dimension(200, 30));
        authorSecondName.setPreferredSize(new Dimension(200, 30));

        yearOfPublication = new JTextField("" + item.yearOfPublication);
        yearOfPublication.setPreferredSize(new Dimension(50, 30));
        itemPanel.setLayout(new BorderLayout());

        for(Chapter chapter : item.chapters){
            chapterPanels.add(new ChapterPanel(chapter));
            tabbedPane.addTab(chapterPanels.get(chapterPanels.size()-1).getName(),chapterPanels.get(chapterPanels.size() - 1).getPanel());
        }

        JPanel topPanel = new JPanel();
        topPanel.add(authorLabel);
        topPanel.add(authorFirstName);
        topPanel.add(authorSecondName);
        topPanel.add(yearOfPublicationLabel);
        topPanel.add(yearOfPublication);
        itemPanel.add(topPanel, BorderLayout.NORTH);

        itemPanel.add(tabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton updateItemButton = new JButton("Обновить статью");
        updateItemButton.addActionListener(e -> updateItem());
        buttonPanel.add(updateItemButton);

        JButton deleteItemButton = new JButton("Удалить статью");
        deleteItemButton.addActionListener(e -> deleteItem());
        buttonPanel.add(deleteItemButton);

        JButton addChapterButton = new JButton("Добавить главу");
        addChapterButton.addActionListener(e -> addChapter());
        buttonPanel.add(addChapterButton);

        itemPanel.add(buttonPanel, BorderLayout.SOUTH);

        setFont();
    }

    private void addChapter() {

    }

    private void deleteItem() {
        clientController.deleteItem(name);
        mainFrame.update();
    }

    private void updateItem() {
        Item item = new Item(name,
                Integer.parseInt(yearOfPublication.getText()),
                getAuthor(), getChapters());
        clientController.updateItem(item);
    }

    private Author getAuthor(){
        return new Author(authorFirstName.getText(), authorSecondName.getText());
    }

    private void setFont(){
        authorFirstName.setFont(MAIN_FONT);
        authorSecondName.setFont(MAIN_FONT);
        yearOfPublication.setFont(MAIN_FONT);
        authorLabel.setFont(MAIN_FONT);
        yearOfPublicationLabel.setFont(MAIN_FONT);

    }

    public JPanel getPanel() {
        return itemPanel;
    }

    public String getName() {
        return name;
    }

    private List<Chapter> getChapters() {
        List<Chapter> chapters = new ArrayList<>();
        for (ChapterPanel chapterPanel : chapterPanels)
            chapters.add(chapterPanel.getChapter());
        return chapters;
    }
}
