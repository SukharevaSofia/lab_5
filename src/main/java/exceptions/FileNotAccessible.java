package exceptions;

public class FileNotAccessible extends Exception {

    public FileNotAccessible() {
    }

    public FileNotAccessible(final String message) {
        super(message);
    }

    public FileNotAccessible(final Throwable cause) {
        super(cause);
    }

    public FileNotAccessible(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FileNotAccessible(final String message, final Throwable cause, final boolean enableSuppression,
                             final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
