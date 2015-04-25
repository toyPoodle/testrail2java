package de.vik.testrail2java;

public class TestRailException extends RuntimeException {
    public TestRailException() {
        super();
    }

    public TestRailException(String message) {
        super(message);
    }

    public TestRailException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestRailException(Throwable cause) {
        super(cause);
    }

    protected TestRailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
