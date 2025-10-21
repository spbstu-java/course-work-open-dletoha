
package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import gui.components.ConsoleOutputArea;
import gui.components.InputForm;
import labs.lab4.steamApiMethods.MyMethods;

public class Lab4Panel extends JPanel {
    public Lab4Panel() {
        setLayout(new BorderLayout());

        ConsoleOutputArea output = new ConsoleOutputArea();
        add(new JScrollPane(output), BorderLayout.CENTER);

        InputForm intListForm = new InputForm("Числа (через запятую):");
        InputForm stringListForm = new InputForm("Строки (через запятую):");

        JButton avgButton = new JButton("Среднее");
        JButton transformButton = new JButton("Преобразовать строки");
        JButton uniqueSquaresButton = new JButton("Квадраты уникальных");
        JButton lastElementButton = new JButton("Последний элемент");
        JButton evenSumButton = new JButton("Сумма чётных");
        JButton toMapButton = new JButton("Строки в Map");

        avgButton.addActionListener(e -> {
            List<Integer> nums = intListForm.getIntegerList();
            double avg = MyMethods.average(nums);
            output.print("Среднее: " + avg);
        });

        transformButton.addActionListener(e -> {
            List<String> strs = stringListForm.getStringList();
            List<String> result = MyMethods.transformStrings(strs);
            output.print("Преобразованные строки: " + result);
        });

        uniqueSquaresButton.addActionListener(e -> {
            List<Integer> nums = intListForm.getIntegerList();
            List<Integer> result = MyMethods.uniqueSquares(nums);
            output.print("Квадраты уникальных: " + result);
        });

        lastElementButton.addActionListener(e -> {
            List<String> strs = stringListForm.getStringList();
            String last = MyMethods.getLastElement(strs);
            output.print("Последний элемент: " + last);
        });

        evenSumButton.addActionListener(e -> {
            int[] arr = intListForm.getIntArray();
            int sum = MyMethods.sumEven(arr);
            output.print("Сумма чётных: " + sum);
        });

        toMapButton.addActionListener(e -> {
            List<String> strs = stringListForm.getStringList();
            Map<Character, String> map = MyMethods.toCharMap(strs);
            output.print("Map:");
            map.forEach((k, v) -> output.print(k + " -> " + v));
        });

        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        inputPanel.add(intListForm);
        inputPanel.add(stringListForm);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        buttonPanel.add(avgButton);
        buttonPanel.add(evenSumButton);
        buttonPanel.add(uniqueSquaresButton);
        buttonPanel.add(transformButton);
        buttonPanel.add(lastElementButton);
        buttonPanel.add(toMapButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
    }
}
