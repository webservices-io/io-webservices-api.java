package io.webservices.api.document.model.merge;

import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.WebservicesResponse;

/**
 * Class representing a merge response.
 *
 * @author Rintcius Blok
 */
public class MergeResponse implements WebservicesResponse {

    /**
     * The document of the merge response.
     */
    private Document document;

    /**
     * Creates a MergeResponse
     */
    public MergeResponse() {
    }

    /**
     * Creates a MergeResponse with the supplied document.
     *
     * @param document The document
     */
    public MergeResponse(Document document) {
        this.document = document;
    }

    /**
     * Returns the document of the merge response.
     *
     * @return The document
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Sets the document of the merge response,
     *
     * @param document The document
     */
    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MergeResponse that = (MergeResponse) o;

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
        sb.append("MergeResponse");
        sb.append("{document=").append(document);
        sb.append('}');
        return sb.toString();
    }
}
