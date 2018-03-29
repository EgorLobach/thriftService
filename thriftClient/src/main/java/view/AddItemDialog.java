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

class AddItemDialog{
    private JDialog addItemDialog = new JDialog();

    private JTextField name = new JTextField(30);
    private ClientController clientController;

    AddItemDialog(ClientController clientController) {
        this.clientController =clientController;
        addItemDialog.setSize(300, 200);
        addItemDialog.setLocationRelativeTo(null);
        addItemDialog.setResizable(false);
        addItemDialog.setModal(true);
        addItemDialog.setLayout(new BorderLayout());

        addItemDialog.setTitle("Добавить статью");
        JButton button = new JButton("Добавить");
        JLabel nameLabel = new JLabel("Название");

        nameLabel.setFont(MAIN_FONT);
        name.setFont(MAIN_FONT);

        addItemDialog.add(nameLabel, BorderLayout.NORTH);
        addItemDialog.add(name, BorderLayout.CENTER);
        addItemDialog.add(button, BorderLayout.SOUTH);

        button.addActionListener(e -> action());
        addItemDialog.pack();
        addItemDialog.setVisible(true);
    }

    private void action() {
        if(name.getText().isEmpty()){
            JOptionPane.showMessageDialog(addItemDialog, "Поле пустое",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String str = name.getText();
            List<Chapter> chapters = new ArrayList<>();
            chapters.add(new Chapter("new chapter", ""));
            Item item = new Item(str, 2018, new Author("", ""), chapters);
            clientController.addItem(item);
            addItemDialog.dispose();
        }
    }
}
