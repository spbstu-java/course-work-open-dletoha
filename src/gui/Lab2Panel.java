
package gui;

import java.awt.*;
import javax.swing.*;
import gui.components.ConsoleOutputArea;
import labs.lab2.invoker.AnnotationInvoker;

public class Lab2Panel extends JPanel {
    public Lab2Panel() {
        setLayout(new BorderLayout());

        ConsoleOutputArea output = new ConsoleOutputArea();
        add(new JScrollPane(output), BorderLayout.CENTER);

        JTextField inputField = new JTextField(30);
        JButton runButton = new JButton("Выполнить методы с @Repeat");

        runButton.addActionListener(e -> {
            output.clear();
            String userInput = inputField.getText();
            AnnotationInvoker.runWithInput(userInput, output::print);
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Аргументы (через запятую):"));
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(runButton);

        controlPanel.add(inputPanel);
        controlPanel.add(buttonPanel);

        add(controlPanel, BorderLayout.NORTH);
    }
}
