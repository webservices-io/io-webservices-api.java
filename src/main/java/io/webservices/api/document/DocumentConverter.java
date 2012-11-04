package io.webservices.api.document;

import io.webservices.api.Webservice;
import io.webservices.api.WebservicesException;
import io.webservices.api.document.model.convert.ConvertRequest;
import io.webservices.api.document.model.convert.ConvertResponse;

/**
 * Interface for the DocumentConverter webservice.
 *
 * @author Rintcius Blok
 */
public interface DocumentConverter extends Webservice {

    /**
     * Converts a document using the supplied ConvertRequest.
     * @param convertRequest The convert request
     * @return The convert response
     * @throws WebservicesException
     */
    ConvertResponse convert(ConvertRequest convertRequest) throws WebservicesException;
}
