package hust.soict.dsai.aims.exception;

public class LimitExceededException extends Exception {
    // Constructor mặc định
    public LimitExceededException() {
        super("Limit exceeded!"); // Thông báo mặc định
    }

    // Constructor với thông báo tùy chỉnh
    public LimitExceededException(String message) {
        super(message);
    }

    // Constructor với thông báo và nguyên nhân
    public LimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor với nguyên nhân
    public LimitExceededException(Throwable cause) {
        super(cause);
    }
}
