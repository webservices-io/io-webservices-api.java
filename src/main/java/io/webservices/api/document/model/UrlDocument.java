package io.webservices.api.document.model;

/**
 * Class representing a document located at a URL. This may be a standard URL or a cloud URL (which is specific for
 * webservices.io). This class further holds the format of the document.
 *
 * See http://webservices.io/api#cloudUrl
 * See http://webservices.io/api#documentFormat
 *
 * @author Rintcius Blok
 */
public class UrlDocument implements Document {
    /**
     * The location of the document as standard URL or cloud URL.
     */
    private String url;

    /**
     * The format of the document.
     */
    private String format;

    /**
     * Creates a UrlDocument.
     */
    public UrlDocument() {
    }

    /**
     * Creates a UrlDocument with the specified URL and document format.
     *
     * @param url The URL
     * @param format The document format
     */
    public UrlDocument(String url, String format) {
        this.url = url;
        this.format = format;
    }

    /**
     * Returns the URL of the document.
     *
     * @return The URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the document.
     *
     * @param value The url
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Returns the format of the document.
     *
     * @return The format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the document.
     *
     * @param value The format
     */
    public void setFormat(String value) {
        this.format = value;
    }

    @Override
    public Class<UrlDocument> getDocumentClass() {
        return UrlDocument.class;
    }

    @Override
    public <T extends Document> T as(Class<T> clazz) {
        return (T) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UrlDocument that = (UrlDocument) o;

        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UrlDocument");
        sb.append("{url='").append(url).append('\'');
        sb.append(", format='").append(format).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
