package io.webservices.api.document.model;

import java.util.List;

/**
 * Class representing an error response.
 *
 * @author Rintcius Blok
 */
public class ErrorResponse implements WebservicesResponse {
    /**
     * The list of errors that are part of the error response.
     */
    private List<String> errors;

    /**
     * Constructs an ErrorResponse.
     */
    public ErrorResponse() {
    }

    /**
     * Constructs an ErrorResponse with the supplied errors.
     *
     * @param errors the list of errors
     */
    public ErrorResponse(List<String> errors) {
        this.errors = errors;
    }

    /**
     * Returns the errors of the error response.
     *
     * @return The list of errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Sets the errors of the error response.
     * @param errors The list of errors
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorResponse that = (ErrorResponse) o;

        if (errors != null ? !errors.equals(that.errors) : that.errors != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return errors != null ? errors.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ErrorResponse");
        sb.append("{errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}
