package io.webservices.api.document;

import io.webservices.api.Webservice;
import io.webservices.api.WebservicesException;
import io.webservices.api.document.model.merge.MergeRequest;
import io.webservices.api.document.model.merge.MergeResponse;

/**
 * Interface for the DocumentMerger webservice.
 *
 * @author Rintcius Blok
 */
public interface DocumentMerger extends Webservice {

    /**
     * Merges a document using the supplied MergeRequest.
     * @param mergeRequest The merge request
     * @return The merge response
     * @throws WebservicesException
     */
    MergeResponse merge(MergeRequest mergeRequest) throws WebservicesException;
}
