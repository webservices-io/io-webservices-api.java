package io.webservices.api.document;

import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.UrlDocument;
import io.webservices.api.document.model.merge.MergeRequest;
import io.webservices.api.document.model.merge.MergeResponse;
import io.webservices.test.AbstractClientTest;
import io.webservices.test.utils.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Rintcius Blok
 */
public class DocumentMergerClientTest extends AbstractClientTest {

    private DocumentMergerClient createMerger() {
        return new DocumentMergerClient(cfg);
    }

    @Test
    public void mergeBytesToBytes() {
        MergeRequest request = DocumentMergerSamples.bytesToBytesRequest();

        MergeResponse expectedResponse = new MergeResponse(new BytesDocument(TestUtils.resourcePathToBytes("document/merge/result/HalloWorld.pdf"), "pdf"));
        assertOk(request, expectedResponse);
    }

    @Test
    public void mergeBytesToCloud() {
        MergeRequest request = DocumentMergerSamples.bytesToCloudRequest();

        MergeResponse expectedResponse = new MergeResponse(new UrlDocument("s3://public.webservices.io/demo/result/HalloWorld.pdf", "pdf"));
        assertOk(request, expectedResponse);
    }

    @Test
    public void mergeCloudToBytes() {
        MergeRequest request = DocumentMergerSamples.cloudToBytesRequest();

        MergeResponse expectedResponse = new MergeResponse(new BytesDocument(TestUtils.resourcePathToBytes("document/merge/result/HalloWorld.pdf"), "pdf"));
        assertOk(request, expectedResponse);
    }

    @Test
    public void mergeCloudToCloud() {
        MergeRequest request = DocumentMergerSamples.cloudToCloudRequest();

        MergeResponse expectedResponse = new MergeResponse(new UrlDocument("s3://public.webservices.io/demo/result/HalloWorld.pdf", "pdf"));
        assertOk(request, expectedResponse);
    }

    private void assertOk(MergeRequest request, MergeResponse expectedResponse) {
        DocumentMergerClient merger = createMerger();
        MergeResponse response = merger.merge(request);
        assertEquals(expectedResponse, response);
    }
}
