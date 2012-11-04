package io.webservices.api.document.model.merge;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.webservices.api.document.model.ErrorResponse;

/**
 * A wrapper class for merge responses. It will usually hold either a MergeResponse or an ErrorResponse.
 *
 * @author Rintcius Blok
 */
public class MergeResponseWrapper {

    /**
     * The merge response.
     */
    private MergeResponse mergeResponse;

    /**
     * The error response.
     */
    @JsonUnwrapped
    private ErrorResponse errorResponse;

    /**
     * Creates a MergeResponseWrapper.
     */
    public MergeResponseWrapper() {
    }

    /**
     * Creates a MergeResponseWrapper with the supplied MergeResponse and ErrorResponse.
     *
     * @param mergeResponse The merge response
     * @param errorResponse The error response
     */
    public MergeResponseWrapper(MergeResponse mergeResponse, ErrorResponse errorResponse) {
        this.mergeResponse = mergeResponse;
        this.errorResponse = errorResponse;
    }

    /**
     * Returns the MergeResponse of the wrapper.
     *
     * @return The merge response
     */
    public MergeResponse getMergeResponse() {
        return mergeResponse;
    }

    /**
     * Sets the MergeResponse of the wrapper.
     *
     * @param mergeResponse The merge response
     */
    public void setMergeResponse(MergeResponse mergeResponse) {
        this.mergeResponse = mergeResponse;
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
