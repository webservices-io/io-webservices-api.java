package io.webservices.api.document.model.convert;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.webservices.api.document.model.ErrorResponse;

import java.util.List;

/**
 * A wrapper class for convert responses. It will usually hold either a ConvertResponse or an ErrorResponse.
 *
 * @author Rintcius Blok
 */
public class ConvertResponseWrapper {

    /**
     * The convert response.
     */
    private ConvertResponse convertResponse;

    /**
     * The error response.
     */
    @JsonUnwrapped
    private ErrorResponse errorResponse;

    /**
     * Creates a ConvertResponseWrapper.
     */
    public ConvertResponseWrapper() {
    }

    /**
     * Creates a ConvertResponseWrapper with the supplied ConvertResponse and ErrorResponse.
     *
     * @param convertResponse The convert response
     * @param errorResponse The error response
     */
    public ConvertResponseWrapper(ConvertResponse convertResponse, ErrorResponse errorResponse) {
        this.convertResponse = convertResponse;
        this.errorResponse = errorResponse;
    }

    /**
     * Returns the ConvertResponse of the wrapper.
     *
     * @return The convert response
     */
    public ConvertResponse getConvertResponse() {
        return convertResponse;
    }

    /**
     * Sets the ConvertResponse of the wrapper.
     *
     * @param convertResponse The convert response
     */
    public void setConvertResponse(ConvertResponse convertResponse) {
        this.convertResponse = convertResponse;
    }

    /**
     * Returns the ErrorResponse of the wrapper.
     *
     * @return The error response
     */
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    /**
     * Sets the error response of the wrapper
     *
     * @param errorResponse The error response
     */
    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
