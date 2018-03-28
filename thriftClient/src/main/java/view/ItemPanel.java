package view;

import aipos.model.Item;

import javax.swing.*;

public class ItemPanel {

    String name;
    JPanel panel;

    JLabel authorLabel = new JLabel("Автор:");
    JTextField author;
    ChapterPanel chapterPanel;
    JLabel yearOfPublicationLabel = new JLabel("Год публикации");
    JTextField yearOfPublication;




    ItemPanel(Item item){
        name = item.name;
        author = new JTextField("" + item.author.firstName + " " + item.author.secondName);
        chapterPanel = new ChapterPanel(item);
        yearOfPublication = new JTextField("" + item.yearOfPublication);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(authorLabel);
        panel.add(author);
        panel.add(chapterPanel.getPanel());
        panel.add(yearOfPublicationLabel);
        panel.add(yearOfPublication);

    }

    public JPanel getPanel() {
        return panel;
    }

    public String getName() {
        return name;
    }
}
