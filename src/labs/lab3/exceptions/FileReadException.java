package labs.lab3.exceptions;

// Выбрасывается при проблемах открытия/чтения файла
public class FileReadException extends Exception {
    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
