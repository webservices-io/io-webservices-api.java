package io.webservices.api.document;

import io.webservices.api.WebservicesConfiguration;
import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.UrlDocument;
import io.webservices.api.document.model.convert.ConvertRequest;
import io.webservices.api.document.model.convert.ConvertResponse;
import io.webservices.test.utils.TestUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Class showing how the DocumentConverter works. It is extensively documented to get you started as quickly as possible.
 *
 * @author Rintcius Blok
 */
public class DocumentConverterDemo {

    public static void main(String[] args) throws IOException {

        // ***************************************************
        // *** STEP 1 Set up SSL                           ***
        // ***************************************************
        // This sets the javax.net.ssl.trustStore property to use the truststore that is provided as a test resource,
        // so the demo will run out-of-the-box. This truststore contains an entry to just trust api.webservices.io.
        // See http://webservices.io/ssl for more info.
        TestUtils.setTestTrustStoreAsSystemProperty();

        // ***************************************************
        // *** STEP 2 Create the webservices configuration ***
        // ***************************************************
        // This configures the client for testing with a predefined demo account.
        // Note: This demo account will only work with the demo requests.
        // So in order to try your own requests you have to use your own credentials.
        WebservicesConfiguration cfg = new WebservicesConfiguration("demo@webservices.io", "secret");

        // ***************************************************
        // *** STEP 3 Create the DocumentConverter         ***
        // ***************************************************
        DocumentConverter documentConverter = new DocumentConverterClient(cfg);

        // An alternative way is to get the DocumentConverter via the WebservicesClient.
        // This is more convenient in case you are using more than 1 service.
        //   WebservicesClient client = new WebservicesClient(cfg);
        //   DocumentConverter documentConverter = client.createDocumentConverter();

        // ***************************************************
        // *** STEP 4 Create the ConvertRequest            ***
        // ***************************************************
        // Create a ConvertRequest in some way (or another):
        ConvertRequest convertRequest = DocumentConverterSamples.bytesToBytesRequest();
        //   ConvertRequest convertRequest = DocumentConverterSamples.cloudToBytesRequest();

        // ***************************************************
        // *** STEP 5 Convert!                             ***
        // ***************************************************
        ConvertResponse convertResponse = documentConverter.convert(convertRequest);

        // ***************************************************
        // *** STEP 6 Do something with the response       ***
        // ***************************************************
        // This assumes that we got a BytesDocument, which is the case for the samples bytesToBytesRequest
        // and cloudToBytesRequest.
        doSomethingGreatWith(convertResponse.getDocument().as(BytesDocument.class));
        // Depending on the request it can also be an UrlDocument
        // (e.g. in case of these sample requests: bytesToCloudRequest and cloudToCloudRequest).
        // In that case you would:
        //   doSomethingGreatWith(convertResponse.getDocument().as(UrlDocument.class));
    }

    private static void doSomethingGreatWith(BytesDocument document) throws IOException {
        // let's save it...
        String filename = "converted." + document.getFormat();
        FileUtils.writeByteArrayToFile(new File(filename), document.getBytes());
        System.out.println("Conversion completed. Wrote result to " + filename);
    }


    private static void doSomethingGreatWith(UrlDocument document) throws IOException {
        // let's print something...
        System.out.println("Conversion completed. Document available in cloud at " + document.getUrl() + " with format " + document.getFormat());
    }
}
