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
    private ItemPanel itemPanel;

    ChapterPanel(Chapter chapter, ItemPanel itemPanel) {
        this.itemPanel = itemPanel;
        chapterPanel = new JPanel();
        chapterPanel.setLayout(new BorderLayout());
        name = chapter.name;
        text = new JTextArea(chapter.text);
        text.setFont(MAIN_FONT);
        chapterPanel.add(text, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton renameChapterButton = new JButton("Переименовать главу");
        renameChapterButton.addActionListener(e -> renameChapter());
        buttonPanel.add(renameChapterButton);
        JButton deleteChapterButton = new JButton("Удалить главу");
        deleteChapterButton.addActionListener(e -> deleteChapter());
        buttonPanel.add(deleteChapterButton);
        chapterPanel.add(buttonPanel, BorderLayout.SOUTH);

    }

    private void renameChapter() {
        new RenameChapterDialog(itemPanel, "Переименовать главу", this);
    }

    private void deleteChapter() {
        itemPanel.deleteChapter(this);
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

    public void setName(String name) {
        this.name = name;
    }
}
