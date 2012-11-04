package io.webservices.api.document;

import io.webservices.api.WebservicesConfiguration;
import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.UrlDocument;
import io.webservices.api.document.model.convert.ConvertRequest;
import io.webservices.api.document.model.convert.ConvertResponse;
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
        // *** STEP 1 Create the webservices configuration ***
        // ***************************************************
        // This configures the client for testing.
        // The insecure SSLSecurityType basically means that you don't have to install any SSL certificate, so this sample runs out of the box.
        // This should not be used in production though.
        WebservicesConfiguration cfg = new WebservicesConfiguration("demo@webservices.io", "secret", WebservicesConfiguration.SSLSecurityType.INSECURE);
        // In production you would typically install the SSL certificate (see http://webservices.io/ssl) and configure like this:
        //   WebservicesConfiguration cfg = new WebservicesConfiguration("demo@webservices.io", "secret");

        // ***************************************************
        // *** STEP 2 Create the DocumentConverter         ***
        // ***************************************************
        DocumentConverter documentConverter = new DocumentConverterClient(cfg);

        // An alternative way is to get the DocumentConverter via the WebservicesClient.
        // This is more convenient in case you are using more than 1 service.
        //   WebservicesClient client = new WebservicesClient(cfg);
        //   DocumentConverter documentConverter = client.createDocumentConverter();

        // ***************************************************
        // *** STEP 3 Create the ConvertRequest            ***
        // ***************************************************
        // Create a ConvertRequest in some way (or another):
        ConvertRequest convertRequest = DocumentConverterSamples.bytesToBytesRequest();
        //   ConvertRequest convertRequest = DocumentConverterSamples.cloudToBytesRequest();

        // ***************************************************
        // *** STEP 4 Convert!                             ***
        // ***************************************************
        ConvertResponse convertResponse = documentConverter.convert(convertRequest);

        // ***************************************************
        // *** STEP 5 Do something with the response       ***
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
        FileUtils.writeByteArrayToFile(new File("converted." + document.getFormat()), document.getBytes());
    }


    private static void doSomethingGreatWith(UrlDocument document) throws IOException {
        // let's print something...
        System.out.println("Conversion completed. Document available in cloud at " + document.getUrl() + " with format " + document.getFormat());
    }
}
