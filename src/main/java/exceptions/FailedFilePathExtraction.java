package exceptions;

public class FailedFilePathExtraction extends Exception {

    public FailedFilePathExtraction() {
    }

    public FailedFilePathExtraction(final String message) {
        super(message);
    }

    public FailedFilePathExtraction(final Throwable cause) {
        super(cause);
    }

    public FailedFilePathExtraction(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FailedFilePathExtraction(final String message, final Throwable cause, final boolean enableSuppression,
                                    final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
