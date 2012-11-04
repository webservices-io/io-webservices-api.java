package io.webservices.api.document;

import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.UrlDocument;
import io.webservices.api.document.model.convert.ConvertRequest;
import io.webservices.api.document.model.convert.ConvertResponse;
import io.webservices.test.AbstractClientTest;
import io.webservices.test.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Rintcius Blok
 */
public class DocumentConverterClientTest extends AbstractClientTest {

    private DocumentConverterClient createConverter() {
        return new DocumentConverterClient(cfg);
    }

    @Test
    public void convertBytesToBytes() {
        ConvertRequest request = DocumentConverterSamples.bytesToBytesRequest();

        ConvertResponse expectedResponse = new ConvertResponse(new BytesDocument(TestUtils.resourcePathToBytes("document/convert/result/Hallo.pdf"), "pdf"));

        assertOk(request, expectedResponse);
    }

    @Test
    public void convertBytesToCloud() {
        ConvertRequest request = DocumentConverterSamples.bytesToCloudRequest();

        ConvertResponse expectedResponse = new ConvertResponse(new UrlDocument("s3://public.webservices.io/demo/result/Hallo.pdf", "pdf"));

        assertOk(request, expectedResponse);
    }

    @Test
    public void convertCloudToBytes() {
        ConvertRequest request = DocumentConverterSamples.cloudToBytesRequest();

        ConvertResponse expectedResponse = new ConvertResponse(new BytesDocument(TestUtils.resourcePathToBytes("document/convert/result/Hallo.pdf"), "pdf"));

        assertOk(request, expectedResponse);
    }

    @Test
    public void convertCloudToCloud() {
        ConvertRequest request = DocumentConverterSamples.cloudToCloudRequest();

        ConvertResponse expectedResponse = new ConvertResponse(new UrlDocument("s3://public.webservices.io/demo/result/Hallo.pdf", "pdf"));

        assertOk(request, expectedResponse);
    }

    private void assertOk(ConvertRequest request, ConvertResponse expectedResponse) {
        DocumentConverter converter = createConverter();
        ConvertResponse convertResponse = converter.convert(request);
        assertEquals(expectedResponse, convertResponse);
    }
}
