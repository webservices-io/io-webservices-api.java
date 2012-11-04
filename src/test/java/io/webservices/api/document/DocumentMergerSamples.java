package io.webservices.api.document;

import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.UrlDocument;
import io.webservices.api.document.model.merge.MergeRequest;
import io.webservices.test.utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rintcius Blok
 */
public class DocumentMergerSamples {

    public static MergeRequest bytesToBytesRequest() {
        Document template = new BytesDocument(TestUtils.resourcePathToBytes("document/merge/HalloName.doc"), "doc");
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "world");
        Document target = new BytesDocument("pdf");
        return new MergeRequest(template, data, target);
    }

    public static MergeRequest bytesToCloudRequest() {
        Document template = new BytesDocument(TestUtils.resourcePathToBytes("document/merge/HalloName.doc"), "doc");
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "world");
        Document target = new UrlDocument("s3://public.webservices.io/demo/result/HalloWorld.pdf", "pdf");
        return new MergeRequest(template, data, target);
    }

    public static MergeRequest cloudToBytesRequest() {
        Document template = new UrlDocument("s3://public.webservices.io/demo/HalloName.doc", "doc");
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "world");
        Document target = new BytesDocument("pdf");
        return new MergeRequest(template, data, target);
    }

    public static MergeRequest cloudToCloudRequest() {
        Document template = new UrlDocument("s3://public.webservices.io/demo/HalloName.doc", "doc");
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "world");
        Document target = new UrlDocument("s3://public.webservices.io/demo/result/HalloWorld.pdf", "pdf");
        return new MergeRequest(template, data, target);
    }
}
