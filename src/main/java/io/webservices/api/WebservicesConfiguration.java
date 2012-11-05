package io.webservices.api;

/**
 * Holds the configuration for accessing the webservices at webservices.io.
 *
 * @author Rintcius Blok
 */
public class WebservicesConfiguration {

    /**
     * The default base url for accessing the webservices.
     */
    public final static String DEFAULT_BASE_URL = "https://api.webservices.io";

    /**
     * The username to use for accessing the webservices.
     */
    private final String username;

    /**
     * The password to use for accessing the webservices.
     */
    private final String password;

    /**
     * The base url to use for accessing the webservices.
     */
    private final String baseUrl;

    /**
     * Constructs a WebservicesConfiguration based on the supplied username and password.
     * The default base url is used.
     *
     * @param username The username
     * @param password The password
     */
    public WebservicesConfiguration(String username, String password) {
        this(username, password, DEFAULT_BASE_URL);
    }

    /**
     * Constructs a WebservicesConfiguration based on the supplied username, password and base url.
     *
     * @param username        The username
     * @param password        The password
     * @param baseUrl         The base url
     */
    public WebservicesConfiguration(String username, String password, String baseUrl) {
        this.username = username;
        this.password = password;
        this.baseUrl = baseUrl;
    }

    /**
     * Returns the configured username.
     *
     * @return The user name
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the configured password.
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the configured base url
     *
     * @return The base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }
}
