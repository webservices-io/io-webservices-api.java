package io.webservices.api.document.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.UrlDocument;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Jackson helper class to deserialize a Document.
 *
 * @author Rintcius Blok
 */
public class DocumentJsonDeserializer extends StdDeserializer<Document> {
    private Map<String, Class<? extends Document>> registry =
            new HashMap<String, Class<? extends Document>>();

    /**
     * Creates a DocumentJsonDeserializer.
     */
    public DocumentJsonDeserializer() {
        super(Document.class);
        register("url", UrlDocument.class);
        register("bytes", BytesDocument.class);
    }

    /**
     * Registers a unique attribute that is used to identify the supplied documentClass
     *
     * @param uniqueAttribute The unique attribute
     * @param documentClass The document class
     */
    public void register(String uniqueAttribute, Class<? extends Document> documentClass) {
        registry.put(uniqueAttribute, documentClass);
    }

    @Override
    public Document deserialize(JsonParser jp, DeserializationContext context)
            throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends Document> documentClass = null;

        Iterator<Map.Entry<String, JsonNode>> elementsIterator = root.fields();

        while (elementsIterator.hasNext()) {
            Map.Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            if (registry.containsKey(name)) {
                documentClass = registry.get(name);
                break;
            }
        }
        //TODO find out if something like this can be used:
        //  mapper.treeToValue(root, documentClass);
        Document doc;
        if (documentClass == null) {
            // no url and no bytes -> BytesDocument with just a format
            doc = new BytesDocument(root.get("format").textValue());
        } else if (documentClass.equals(UrlDocument.class)) {
            doc = new UrlDocument(root.get("url").textValue(), root.get("format").textValue());
        } else if (documentClass.equals(BytesDocument.class)) {
            doc = new BytesDocument(root.get("bytes").binaryValue(), root.get("format").textValue());
        } else {
            throw new IllegalStateException("Unexpected documentClass: " + documentClass);
        }
        return doc;
    }
}