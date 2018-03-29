package view;

import aipos.model.Chapter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static view.MainFrame.MAIN_FONT;

public class ChapterPanel {
    private JPanel chapterPanel;
    private String name;
    private JTextArea text;

    ChapterPanel(Chapter chapter) {
        chapterPanel = new JPanel();
        chapterPanel.setLayout(new BorderLayout());
        name = chapter.name;
        text = new JTextArea(chapter.text);
        text.setFont(MAIN_FONT);
        chapterPanel.add(text, BorderLayout.CENTER);
    }

    Chapter getChapter(){
        return new Chapter(name, text.getText());
    }

    public String getName() {
        return name;
    }

    public Component getPanel() {
        return chapterPanel;
    }
}
