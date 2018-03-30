package view;

import aipos.model.Author;
import aipos.model.Chapter;
import aipos.model.Item;
import xml.ClientController;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

class AddItemDialog extends Dialog{


    AddItemDialog(ClientController clientController, String string) {
        super(clientController, string);
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
            List<Chapter> chapters = new ArrayList<>();
            chapters.add(new Chapter("new chapter", ""));
            Item item = new Item(str, 2018, new Author("", ""), chapters);
            clientController.addItem(item);
            dialog.dispose();
        }
    }
}
