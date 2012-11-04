package io.webservices.api.document;

import io.webservices.api.WebservicesConfiguration;
import io.webservices.api.WebservicesException;
import io.webservices.api.document.model.merge.MergeRequest;
import io.webservices.api.document.model.merge.MergeResponse;
import io.webservices.api.document.model.merge.MergeResponseWrapper;
import io.webservices.api.utils.WebservicesRestTemplate;
import io.webservices.api.utils.WebservicesRestTemplateFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Client implementing the DocumentMerger webservice interface.
 *
 * @author Rintcius Blok
 */
public class DocumentMergerClient implements DocumentMerger {

    /**
     * The relative part to access this webservice.
     */
    private final static String MERGE_URL_PART = "/v1/document/merge.json";

    /**
     * The RestTemplate used for this webservice.
     */
    private RestTemplate restTemplate;

    /**
     * The accesspoint of this webservice.
     */
    private String url;

    /**
     * Creates the DocumentMergerClient with the supplied WebservicesConfiguration.
     *
     * @param cfg The webservice configuration
     */
    public DocumentMergerClient(WebservicesConfiguration cfg) {
        this(new WebservicesRestTemplateFactory(cfg).createWebservicesRestTemplate());
    }

    /**
     * Creates the DocumentMergerClient based on the supplied WebservicesRestTemplate.
     *
     * @param webservicesRestTemplate The webservices rest template
     */
    public DocumentMergerClient(WebservicesRestTemplate webservicesRestTemplate) {
        this.restTemplate = webservicesRestTemplate.getRestTemplate();
        this.url = webservicesRestTemplate.getBaseUrl() + MERGE_URL_PART;
    }

    @Override
    public MergeResponse merge(MergeRequest mergeRequest) throws WebservicesException {
        MergeResponseWrapper responseWrapper = restTemplate.postForObject(url, mergeRequest, MergeResponseWrapper.class);
        if (responseWrapper.getMergeResponse() != null) {
            return responseWrapper.getMergeResponse();
        } else {
            throw new WebservicesException(responseWrapper.getErrorResponse().toString());
        }
    }

    /**
     * Merges a document using the supplied MergeRequest, returning the raw JSON. This method is not part of the
     * DocumentMerger interface and is not used normally. It can be used for debugging purposes.
     *
     * @param mergeRequest The merge request
     * @return The JSON as returned from the server
     */
    public String mergeAsJsonString(MergeRequest mergeRequest) {
        return restTemplate.postForObject(url, mergeRequest, String.class);
    }
}
