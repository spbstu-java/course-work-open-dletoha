package labs.lab2.core;

import labs.lab2.annotaton.Repeat;
import java.util.function.Consumer;

public class MyClass {
    // Public-методы
    @Repeat(2)
    public void greet(String name, Consumer<String> printer) {
        printer.accept("Hello, " + name);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    // Protected-методы
    @Repeat(3)
    protected void log(String message, int num, Consumer<String> printer) {
        printer.accept("LOG " + num + ":" + message);
    }

    protected double multiply(double x, double y) {
        return x * y;
    }

    // Private-методы
    @Repeat(1)
    private void secret(Consumer<String> printer) {
        printer.accept("Этот метод приватный");
    }

    @Repeat(4)
    private String echo(String s) {
        return "Echo: " + s;
    }
}
