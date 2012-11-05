package io.webservices.api.utils;

import io.webservices.api.WebservicesConfiguration;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * A HttpRequestFactory tailored for use at webservices.io. This class extends HttpComponentsClientHttpRequestFactory by
 * providing the credentials that are supplied via the WebservicesConfiguration to the HttpClient.
 *
 * @author Rintcius Blok
 */
public class WebservicesHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

    /**
     * The HttpHost used to configure the HttpClient.
     */
    private final HttpHost httpHost;

    /**
     * Creates a WebservicesHttpRequestFactory based on the supplied WebservicesConfiguration.
     *
     * @param cfg The webservices configuration
     */
    public WebservicesHttpRequestFactory(WebservicesConfiguration cfg) {
        super();
        this.httpHost = parseUrlAsHttpHost(cfg.getBaseUrl());

        if (!(getHttpClient() instanceof DefaultHttpClient)) {
            throw new IllegalStateException("httpClient needs to be a DefaultHttpClient in order to be able to get the CredentailsProvider");
        }
        ((DefaultHttpClient) getHttpClient()).getCredentialsProvider().setCredentials(
                new AuthScope(httpHost),
                new UsernamePasswordCredentials(cfg.getUsername(), cfg.getPassword()));
    }

    /**
     * Parses the supplied base url into a HttpHost.
     *
     * @param baseUrl The base url
     * @return The http host
     */
    private static HttpHost parseUrlAsHttpHost(String baseUrl) {
        URL url;
        try {
            url = new URL(baseUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Cannot parse into URL: " + baseUrl);
        }
        return new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
    }

    @Override
    protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
        return createHttpContext();
    }

    /**
     * Creates a HttpContext setting the AuthCache based on httpHost.
     *
     * @return the created HttpContext
     */
    private HttpContext createHttpContext() {
        AuthCache authCache = new BasicAuthCache();
        authCache.put(httpHost, new BasicScheme());

        BasicHttpContext httpContext = new BasicHttpContext();
        httpContext.setAttribute(ClientContext.AUTH_CACHE, authCache);

        return httpContext;
    }
}