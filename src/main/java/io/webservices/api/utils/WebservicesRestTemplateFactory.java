package io.webservices.api.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.webservices.api.WebservicesConfiguration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class for WebservicesRestTemplate. It creates a WebservicesRestTemplate based on a WebservicesConfiguration.
 *
 * @author Rintcius Blok
 */
public class WebservicesRestTemplateFactory {

    /**
     * The WebservicesConfiguration used for creating WebservicesRestTemplate.
     */
    private final WebservicesConfiguration cfg;

    /**
     * Creates a WebservicesRestTemplateFactory based on the supplied WebservicesConfiguration.
     *
     * @param cfg The webservices configuration
     */
    public WebservicesRestTemplateFactory(WebservicesConfiguration cfg) {
        this.cfg = cfg;
    }

    /**
     * Creates the WebservicesRestTemplate.
     *
     * @return the created WebservicesRestTemplate
     */
    public WebservicesRestTemplate createWebservicesRestTemplate() {
        return new WebservicesRestTemplate(createRestTemplate(), cfg.getBaseUrl());
    }

    /**
     * Creates Spring's RestTemplate based on the webservices configuration. This template is tailored for accessing
     * the webservices.
     *
     * @return The created rest template
     */
    private RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(createRequestFactory(cfg));
        restTemplate.setMessageConverters(createHttpMessageConverters());

        return restTemplate;
    }

    /**
     * Creates the HttpMessageConverters that will be part of the RestTemplate.
     *
     * @return The created list of HttpMessageConverters
     */
    private static List<HttpMessageConverter<?>> createHttpMessageConverters() {
        List<HttpMessageConverter<?>> msgConverters = new ArrayList<HttpMessageConverter<?>>();

        msgConverters.add(new StringHttpMessageConverter());

        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        msgConverters.add(jacksonConverter);

        return msgConverters;
    }

    /**
     * Creates the ClientHttpRequestFactory based on the supplied WebservicesConfiguration.
     *
     * @param cfg The webservice configuration
     * @return The created ClientHttpRequestFactory
     */
    private static ClientHttpRequestFactory createRequestFactory(WebservicesConfiguration cfg) {
        return new WebservicesHttpRequestFactory(cfg);
    }

}
