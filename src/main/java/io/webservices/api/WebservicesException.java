package io.webservices.api;

/**
 * Exception class which is thrown if an error occurs when calling a webservice.
 *
 * @author Rintcius Blok
 */
public class WebservicesException extends RuntimeException {

    /**
     * Constructs a WebservicesException with the supplied message.
     *
     * @param message The message
     */
    public WebservicesException(String message) {
        super(message);
    }

    /**
     * Constructs a WebservicesException with the supplied message and nested throwable.
     *
     * @param message   The message
     * @param throwable The nested throwable
     */
    public WebservicesException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a WebservicesException with the supplied nested throwable.
     *
     * @param throwable The nested throwable
     */
    public WebservicesException(Throwable throwable) {
        super(throwable);
    }
}
