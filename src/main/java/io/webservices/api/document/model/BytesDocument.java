package io.webservices.api.document.model;

import java.util.Arrays;

/**
 * Class representing a document that holds the contents as bytes. It further holds the format of the document.
 *
 * @author Rintcius Blok
 */
public class BytesDocument implements Document {

    /**
     * The contents of the document as a byte array.
     */
    private byte[] bytes;

    /**
     * The format of the document.
     */
    private String format;

    /**
     * Creates a BytesDocument
     */
    public BytesDocument() {
    }

    /**
     * Creates a BytesDocument with the specified byte array and document format.
     *
     * @param bytes The byte array
     * @param format The document format
     */
    public BytesDocument(byte[] bytes, String format) {
        this.bytes = bytes;
        this.format = format;
    }

    /**
     * Creates a BytesDocument with the specified document format.
     *
     * @param format The document format
     */
    public BytesDocument(String format) {
        this(null, format);
    }

    /**
     * Returns the byte array of the document.
     *
     * @return The byte array
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Sets the byte array of the document.
     *
     * @param value The byte array
     */
    public void setBytes(byte[] value) {
        this.bytes = value;
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
    public Class<BytesDocument> getDocumentClass() {
        return BytesDocument.class;
    }

    @Override
    public <T extends Document> T as(Class<T> clazz) {
        return (T) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BytesDocument that = (BytesDocument) o;

        if (!Arrays.equals(bytes, that.bytes)) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bytes != null ? Arrays.hashCode(bytes) : 0;
        result = 31 * result + (format != null ? format.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BytesDocument");
        sb.append("{bytes=").append(bytes == null ? "null" : "");
        for (int i = 0; bytes != null && i < bytes.length; ++i)
            sb.append(i == 0 ? "" : ", ").append(bytes[i]);
        sb.append(", format='").append(format).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
