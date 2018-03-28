package view;

import aipos.model.Author;
import aipos.model.Item;

import javax.swing.*;
import java.awt.*;

import static view.MainFrame.MAIN_FONT;

public class ItemPanel {

    private String name;
    private JPanel itemPanel;

    private JLabel authorLabel = new JLabel("Автор:");
    private JTextField author;
    private ChapterPanel chapterPanel;
    private JLabel yearOfPublicationLabel = new JLabel("Год публикации");
    private JTextField yearOfPublication;
    private String authorFirstName;
    private String authorSecondName;


    ItemPanel(Item item){
        itemPanel = new JPanel();
        name = item.name;
        authorFirstName = item.author.firstName;
        authorSecondName = item.author.secondName;
        author = new JTextField("" + item.author.firstName + " " + item.author.secondName);
        author.setPreferredSize(new Dimension(500, 30));
        chapterPanel = new ChapterPanel(item);
        yearOfPublication = new JTextField("" + item.yearOfPublication);
        yearOfPublication.setPreferredSize(new Dimension(500, 30));
        itemPanel.setLayout(new BorderLayout());

        JPanel authorPanel = new JPanel();
        authorPanel.add(authorLabel);
        authorPanel.add(author);
        itemPanel.add(authorPanel, BorderLayout.NORTH);

        itemPanel.add(chapterPanel.getTabbedPane(), BorderLayout.CENTER);

        JPanel yearPanel = new JPanel();
        yearPanel.add(yearOfPublicationLabel);
        yearPanel.add(yearOfPublication);
        itemPanel.add(yearPanel, BorderLayout.SOUTH);
        setFont();

    }

    public ChapterPanel getChapterPanel() {
        return chapterPanel;
    }

    public Author getAuthor(){
        return new Author(authorFirstName, authorSecondName);
    }

    public JTextField getYearOfPublication() {
        return yearOfPublication;
    }

    private void setFont(){
        author.setFont(MAIN_FONT);
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
}
