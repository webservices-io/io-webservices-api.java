package io.webservices.api.utils;

import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate that is used for accessing the webservices at webservices.io. This class mainly delegates to Spring's
 * RestTemplate. This class further hold a base url. The access point of the individual webservices will be relative to
 * this base url.
 *
 * @author Rintcius Blok
 */
public class WebservicesRestTemplate {

    /**
     * The RestTemplate used for accessing the webservices at webservices.io.
     */
    private final RestTemplate restTemplate;

    /**
     * The base url used for accessing the webservices at webservices.io.
     */
    private final String baseUrl;

    /**
     * Constructs a WebservicesRestTemplate based on the specified RestTemplate and base url.
     *
     * @param restTemplate The rest template
     * @param baseUrl      The base url
     */
    public WebservicesRestTemplate(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    /**
     * Returns the RestTemplate.
     *
     * @return the rest template
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * Returns the base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }
}
