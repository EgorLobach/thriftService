package view;

import aipos.model.Chapter;
import aipos.model.Item;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ChapterPanel {
    JPanel panel;
    JLabel chapter = new JLabel("Главы");
    List<JTextField> name = new ArrayList<>();
    List<JTextField> text = new ArrayList<>();

    ChapterPanel(Item item) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Chapter chapter : item.chapters){
            name.add(new JTextField(chapter.name));
            text.add(new JTextField(chapter.text));
            if (!name.isEmpty() && !text.isEmpty()){
                panel.add(name.get(name.size()-1));
                panel.add(text.get(text.size()-1));
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
