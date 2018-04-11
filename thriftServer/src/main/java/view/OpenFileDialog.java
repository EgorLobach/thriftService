package view;

import xml.XMLParser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFileDialog {

    public OpenFileDialog(XMLParser parser){
        String currentDirectory = "D:\\work\\java\\AIPOS\\resources";
        JFileChooser fileChooser = new JFileChooser(currentDirectory);
        fileChooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XML Формат", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Загрузить файл");
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            parser.setCurrentDirectory(fileChooser.getSelectedFile().getPath());
        }

    }
}
