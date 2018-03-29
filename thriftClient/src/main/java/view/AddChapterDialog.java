package view;

import aipos.model.Author;
import aipos.model.Chapter;
import aipos.model.Item;
import controller.ClientController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AddChapterDialog extends Dialog {
    private ItemPanel itemPanel;
    AddChapterDialog(ClientController clientController, String string, ItemPanel itemPanel) {
        super(clientController, string);
        this.itemPanel = itemPanel;
        dialog.pack();
        dialog.setVisible(true);
    }

    @Override
    void action() {
        if(name.getText().isEmpty()){
            JOptionPane.showMessageDialog(dialog, "Поле пустое",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String str = name.getText();
            itemPanel.addChapter(str);
            dialog.dispose();
        }
    }
}
