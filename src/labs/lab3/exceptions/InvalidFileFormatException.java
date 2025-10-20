package labs.lab3.exceptions;

// Выбрасывается при ошибках формата строк в словаре
public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}
