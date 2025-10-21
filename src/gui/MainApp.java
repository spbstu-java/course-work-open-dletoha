
package gui;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Лабораторные задания");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            String[] labs = { "Задание 1", "Задание 2", "Задание 3", "Задание 4" };
            JComboBox<String> labSelector = new JComboBox<>(labs);
            JPanel contentPanel = new JPanel(new BorderLayout());

            JButton launchButton = new JButton("Запустить");
            launchButton.addActionListener(e -> {
                String selected = (String) labSelector.getSelectedItem();
                contentPanel.removeAll();
                switch (selected) {
                    case "Задание 1" -> contentPanel.add(new Lab1Panel(), BorderLayout.CENTER);
                    case "Задание 2" -> contentPanel.add(new Lab2Panel(), BorderLayout.CENTER);
                    case "Задание 3" -> contentPanel.add(new Lab3Panel(), BorderLayout.CENTER);
                    case "Задание 4" -> contentPanel.add(new Lab4Panel(), BorderLayout.CENTER);
                }
                contentPanel.revalidate();
                contentPanel.repaint();
            });

            JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Выберите задание:"));
            topPanel.add(labSelector);
            topPanel.add(launchButton);

            frame.getContentPane().add(topPanel, BorderLayout.NORTH);
            frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
