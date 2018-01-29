package top.kiswich.googleoauth.exception;

/**
 * 当获取token时，未获取到token，抛出的异常
 */
public class CodeErrorException extends RuntimeException{

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CodeErrorException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public CodeErrorException() {
        super("error code used ! please check the time since the code got ! ");
    }
}
