
package gui.components;

import javax.swing.*;

public class ConsoleOutputArea extends JTextArea {
    public ConsoleOutputArea() {
        super(15, 50);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public void print(String text) {
        append(text + "\n");
    }

    public void clear() {
        setText("");
    }
}
