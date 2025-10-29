
package gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gui.components.ConsoleOutputArea;
import labs.lab3.loader.DictionaryLoader;
import labs.lab3.service.Translator;

public class Lab3Panel extends JPanel {
    private Map<String, String> dictionary;

    public Lab3Panel() {
        setLayout(new BorderLayout());

        ConsoleOutputArea output = new ConsoleOutputArea();
        add(new JScrollPane(output), BorderLayout.CENTER);

        JTextField inputField = new JTextField();
        JButton translateButton = new JButton("Перевести");
        JButton loadDictButton = new JButton("Загрузить словарь");

        loadDictButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    dictionary = DictionaryLoader.load(file.getAbsolutePath());
                } catch (Exception ex) {
                    output.print("Ошибка: " + ex.getMessage());
                }
            }
        });

        translateButton.addActionListener(e -> {
            if (dictionary == null) {
                output.print("Словарь не загружен.");
                return;
            }
            String text = inputField.getText();
            String translated = Translator.translate(text, dictionary);
            output.print("Перевод: " + translated);
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputField, BorderLayout.CENTER);
        JPanel buttons = new JPanel();
        buttons.add(loadDictButton);
        buttons.add(translateButton);
        topPanel.add(buttons, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
    }
}
