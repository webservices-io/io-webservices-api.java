package io.webservices.api;

/**
 * Holds the configuration for accessing the webservices at webservices.io.
 *
 * @author Rintcius Blok
 */
public class WebservicesConfiguration {

    /**
     * SSL Security Type. This type specifies whether SSL is used in a secure way or insecure way. The secure way is the
     * default and should be used in production. This means that an SSL certificate needs to be installed as explained in
     * http://webservices.io/ssl.
     * For testing purposes a more convenient, but insecure way can be used. With this option no SSL certificate needs
     * to be installed.
     *
     * @see http://webservices.io/ssl
     */
    public static enum SSLSecurityType {
        /**
         * The default security type, which should be used in production.
         */
        SECURE,
        /**
         * A convenience security type, which allows the client to be used without installing a SSL certificate.
         * Note: This option should only be used for testing purposes!
         */
        INSECURE
    }

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
     * The SSL security type to use for accessing the webservices.
     */
    private final SSLSecurityType sslSecurityType;

    /**
     * Constructs a WebservicesConfiguration based on the supplied username and password.
     * The default base url and default SSL security type (SECURE) are used.
     *
     * @param username The username
     * @param password The password
     */
    public WebservicesConfiguration(String username, String password) {
        this(username, password, DEFAULT_BASE_URL, SSLSecurityType.SECURE);
    }

    /**
     * Constructs a WebservicesConfiguration based on the supplied username, password and SSL security type.
     * The default base url is used.
     *
     * @param username        The username
     * @param password        The password
     * @param sslSecurityType The SSL security type
     */
    public WebservicesConfiguration(String username, String password, SSLSecurityType sslSecurityType) {
        this(username, password, DEFAULT_BASE_URL, sslSecurityType);
    }

    /**
     * Constructs a WebservicesConfiguration based on the supplied username, password and base url.
     * The SSL security type is used.
     *
     * @param username The username
     * @param password The password
     * @param baseUrl  The base url
     */
    public WebservicesConfiguration(String username, String password, String baseUrl) {
        this(username, password, baseUrl, SSLSecurityType.SECURE);
    }

    /**
     * Constructs a WebservicesConfiguration based on the supplied username, password, base url and SSL security type.
     *
     * @param username        The username
     * @param password        The password
     * @param baseUrl         The base url
     * @param sslSecurityType The SSL security type
     */
    public WebservicesConfiguration(String username, String password, String baseUrl, SSLSecurityType sslSecurityType) {
        this.username = username;
        this.password = password;
        this.baseUrl = baseUrl;
        this.sslSecurityType = sslSecurityType;
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

    /**
     * Returns the configured SSL security type.
     *
     * @return The SSL security type
     */
    public SSLSecurityType getSslSecurityType() {
        return sslSecurityType;
    }
}
