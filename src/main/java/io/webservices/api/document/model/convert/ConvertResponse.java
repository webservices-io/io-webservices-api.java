package io.webservices.api.document.model.convert;

import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.WebservicesResponse;

/**
 * Class representing a convert response.
 *
 * @author Rintcius Blok
 */
public class ConvertResponse implements WebservicesResponse {

    /**
     * The document of the convert response.
     */
    private Document document;

    /**
     * Creates a ConvertResponse
     */
    public ConvertResponse() {
    }

    /**
     * Creates a ConvertResponse with the supplied document.
     *
     * @param document The document
     */
    public ConvertResponse(Document document) {
        this.document = document;
    }

    /**
     * Returns the document of the convert response.
     *
     * @return The document
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Sets the document of the convert response,
     *
     * @param document The document
     */
    public void setDocument(Document value) {
        this.document = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConvertResponse that = (ConvertResponse) o;

        if (document != null ? !document.equals(that.document) : that.document != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return document != null ? document.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ConvertResponse");
        sb.append("{document=").append(document);
        sb.append('}');
        return sb.toString();
    }
}
