package view;

import controller.ClientController;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private ClientController clientController;

    private JFrame mainFrame;
    private JTabbedPane tabbedPane;

    public MainFrame(ClientController clientController) {
        this.clientController = clientController;
        tabbedPane = new JTabbedPane();
        mainFrame = new JFrame("Thrift Client");
        mainFrame.setSize(new Dimension(1440, 900));
        mainFrame.setPreferredSize(mainFrame.getSize());
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        mainFrame.setVisible(true);
        mainFrame.add(tabbedPane, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }
}
