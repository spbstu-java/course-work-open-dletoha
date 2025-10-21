
package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import gui.components.ConsoleOutputArea;
import labs.lab1.game.Hero;
import labs.lab1.strategy.MovementOption;

public class Lab1Panel extends JPanel {
    public Lab1Panel() {
        setLayout(new BorderLayout());

        ConsoleOutputArea output = new ConsoleOutputArea();
        add(new JScrollPane(output), BorderLayout.CENTER);

        // Выбор стратегии из доступных
        JComboBox<MovementOption> transportBox = new JComboBox<>(MovementOption.values());
        JButton moveButton = new JButton("Двигаться");

        Hero hero = new Hero();

        moveButton.addActionListener(e -> {
            MovementOption option = (MovementOption) transportBox.getSelectedItem();
            if (option != null) {
                hero.setMovementStrategy(option.createStrategy());
                output.print("Выбран: " + option.getDescription());
                hero.move(output::print);
            } else {
                output.print("Стратегия не выбрана.");
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Выберите транспорт:"));
        controlPanel.add(transportBox);
        controlPanel.add(moveButton);

        add(controlPanel, BorderLayout.NORTH);
    }
}
