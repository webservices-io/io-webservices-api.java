package io.webservices.api.document.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.webservices.api.document.utils.DocumentJsonDeserializer;

/**
 * Interface for documents.
 *
 * @author Rintcius Blok
 */
@JsonDeserialize(using = DocumentJsonDeserializer.class)
public interface Document {

    /**
     * Returns the document class of this document.
     *
     * @param <T> A subclass of Document
     * @return The document class
     */
    <T extends Document> Class<T> getDocumentClass();

    /**
     * Casts the document to the specified subclass of Document.
     *
     * @param clazz The class to cast to
     * @param <T> The return type
     * @return The casted document
     */
    <T extends Document> T as(Class<T> clazz);
}
