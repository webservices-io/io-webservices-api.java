package io.webservices.api;

import io.webservices.api.document.DocumentConverter;
import io.webservices.api.document.DocumentConverterClient;
import io.webservices.api.document.DocumentMerger;
import io.webservices.api.document.DocumentMergerClient;
import io.webservices.api.utils.WebservicesRestTemplate;
import io.webservices.api.utils.WebservicesRestTemplateFactory;

/**
 * Client for accessing the webservices available at webservices.io.
 * There are 2 ways to construct a WebservicesClient:
 * <ol>
 * <li>Using a WebservicesConfiguration object - This is the easiest way to work with the client.</li>
 * <li>Using a WebservicesRestTemplate object - With this option you can fully control the way the client is used.
 * This option only needs to be used if the simple option does not suffice.
 * </li>
 * </ol>
 *
 * @author Rintcius Blok
 */
public class WebservicesClient {

    /**
     * The WebservicesRestTemplate used for accessing the webservices.
     */
    private WebservicesRestTemplate webservicesRestTemplate;

    /**
     * Constructs a WebservicesClient based on the specified WebservicesConfiguration.
     *
     * @param cfg The WebservicesConfiguration
     */
    public WebservicesClient(WebservicesConfiguration cfg) {
        this.webservicesRestTemplate = new WebservicesRestTemplateFactory(cfg).createWebservicesRestTemplate();
    }

    /**
     * Constructs a WebservicesClient based on the specified WebservicesRestTemplate.
     *
     * @param webservicesRestTemplate The WebservicesRestTemplate
     */
    public WebservicesClient(WebservicesRestTemplate webservicesRestTemplate) {
        this.webservicesRestTemplate = webservicesRestTemplate;
    }

    /**
     * Creates the DocumentConverter.
     *
     * @return The DocumentConverter
     */
    public DocumentConverter createDocumentConverter() {
        return new DocumentConverterClient(webservicesRestTemplate);
    }

    /**
     * Creates the DocumentMerger
     *
     * @return The DocumentMerger
     */
    public DocumentMerger createDocumentMerger() {
        return new DocumentMergerClient(webservicesRestTemplate);
    }
}
