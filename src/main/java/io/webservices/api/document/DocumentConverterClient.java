package io.webservices.api.document;

import io.webservices.api.WebservicesConfiguration;
import io.webservices.api.WebservicesException;
import io.webservices.api.document.model.convert.ConvertRequest;
import io.webservices.api.document.model.convert.ConvertResponse;
import io.webservices.api.document.model.convert.ConvertResponseWrapper;
import io.webservices.api.utils.WebservicesRestTemplate;
import io.webservices.api.utils.WebservicesRestTemplateFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Client implementing the DocumentConverter webservice interface.
 *
 * @author Rintcius Blok
 */
public class DocumentConverterClient implements DocumentConverter {

    /**
     * The relative part to access this webservice.
     */
    private final static String CONVERT_URL_PART = "/v1/document/convert.json";

    /**
     * The RestTemplate used for this webservice.
     */
    private RestTemplate restTemplate;

    /**
     * The accesspoint of this webservice.
     */
    private String url;

    /**
     * Creates the DocumentConverterClient with the supplied WebservicesConfiguration.
     *
     * @param cfg The webservice configuration
     */
    public DocumentConverterClient(WebservicesConfiguration cfg) {
        this(new WebservicesRestTemplateFactory(cfg).createWebservicesRestTemplate());
    }

    /**
     * Creates the DocumentConverterClient based on the supplied WebservicesRestTemplate.
     *
     * @param webservicesRestTemplate The webservices rest template
     */
    public DocumentConverterClient(WebservicesRestTemplate webservicesRestTemplate) {
        this.restTemplate = webservicesRestTemplate.getRestTemplate();
        this.url = webservicesRestTemplate.getBaseUrl() + CONVERT_URL_PART;
    }

    @Override
    public ConvertResponse convert(ConvertRequest convertRequest) throws WebservicesException {
        ConvertResponseWrapper responseWrapper = restTemplate.postForObject(url, convertRequest, ConvertResponseWrapper.class);
        if (responseWrapper.getConvertResponse() != null) {
            return responseWrapper.getConvertResponse();
        } else {
            throw new WebservicesException(responseWrapper.getErrorResponse().toString());
        }
    }

    /**
     * Converts a document using the supplied ConvertRequest, returning the raw JSON. This method is not part of the
     * DocumentConverter interface and is not used normally. It can be used for debugging purposes.
     *
     * @param convertRequest The convert request
     * @return The JSON as returned from the server
     */
    public String convertAsJsonString(ConvertRequest convertRequest) {
        return restTemplate.postForObject(url, convertRequest, String.class);
    }
}
