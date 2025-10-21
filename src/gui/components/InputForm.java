
package gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class InputForm extends JPanel {
    private final JTextField inputField;

    public InputForm(String labelText) {
        setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        inputField = new JTextField();
        add(label, BorderLayout.WEST);
        add(inputField, BorderLayout.CENTER);
    }

    public List<String> getStringList() {
        String text = inputField.getText().trim();
        return Arrays.asList(text.split("\\s*,\\s*"));
    }

    public List<Integer> getIntegerList() {
        try {
            return getStringList().stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Некорректный ввод чисел", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return List.of();
        }
    }

    public int[] getIntArray() {
        return getIntegerList().stream().mapToInt(i -> i).toArray();
    }

    public void clear() {
        inputField.setText("");
    }
}
