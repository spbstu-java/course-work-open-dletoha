package core;

import annotaton.Repeat;

public class MyClass {
    // Public-методы
    @Repeat(2)
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    // Protected-методы
    @Repeat(3)
    protected void log(String message, int num) {
        System.out.println("LOG " + num + ":" + message);
    }

    protected double multiply(double x, double y) {
        return x * y;
    }

    // Private-методы
    @Repeat(1)
    private void secret() {
        System.out.println("Этот метод приватный");
    }

    @Repeat(4)
    private String echo(String s) {
        return "Echo: " + s;
    }
}
