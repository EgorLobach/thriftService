package view;

import aipos.model.Chapter;
import aipos.model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static view.MainFrame.MAIN_FONT;

public class ChapterPanel {
    private JTabbedPane tabbedPane;

    private List<JTextField> name = new ArrayList<>();
    private List<JTextArea> text = new ArrayList<>();

    public List<Chapter> getChapters() {
        List<Chapter> chapters = new ArrayList<>();
        for(JTextField str: name)
            chapters.add(new Chapter(str.getText(), text.get(name.indexOf(str)).getText()));
        return chapters;
    }

    ChapterPanel(Item item) {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(MAIN_FONT);
        for (Chapter chapter : item.chapters){
            name.add(new JTextField(chapter.name));
            text.add(new JTextArea(chapter.text));
            if (!name.isEmpty() && !text.isEmpty()){
                tabbedPane.addTab((name.get(name.size()-1).getText()), text.get(text.size()-1));
                text.get(text.size()-1).setFont(MAIN_FONT);
            }
        }
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
