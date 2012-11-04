package io.webservices.api.document;

import io.webservices.api.document.model.BytesDocument;
import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.UrlDocument;
import io.webservices.api.document.model.convert.ConvertRequest;
import io.webservices.test.utils.TestUtils;

/**
 * @author Rintcius Blok
 */
public class DocumentConverterSamples {

    public static ConvertRequest bytesToBytesRequest() {
        Document source = new BytesDocument(TestUtils.resourcePathToBytes("document/convert/Hallo.doc"), "doc");
        Document target = new BytesDocument("pdf");
        return new ConvertRequest(source, target);
    }

    public static ConvertRequest bytesToCloudRequest() {
        Document source = new BytesDocument(TestUtils.resourcePathToBytes("document/convert/Hallo.doc"), "doc");
        Document target = new UrlDocument("s3://public.webservices.io/demo/result/Hallo.pdf", "pdf");
        return new ConvertRequest(source, target);
    }

    public static ConvertRequest cloudToBytesRequest() {
        Document source = new UrlDocument("s3://public.webservices.io/demo/Hallo.doc", "doc");
        Document target = new BytesDocument("pdf");
        return new ConvertRequest(source, target);
    }

    public static ConvertRequest cloudToCloudRequest() {
        Document source = new UrlDocument("s3://public.webservices.io/demo/Hallo.doc", "doc");
        Document target = new UrlDocument("s3://public.webservices.io/demo/result/Hallo.pdf", "pdf");
        return new ConvertRequest(source, target);
    }
}
