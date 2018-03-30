package view;

import xml.ClientController;

import javax.swing.*;

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
