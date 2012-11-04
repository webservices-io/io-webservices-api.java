package io.webservices.api.document.model.convert;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.WebservicesRequest;

/**
 * Class representing a convert request.
 *
 * @author Rintcius Blok
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("convertRequest")
public class ConvertRequest implements WebservicesRequest {

    /**
     * The source document of the convert request.
     */
    private Document source;

    /**
     * The target document of the convert request.
     */
    private Document target;

    /**
     * Creates a ConvertRequest.
     */
    public ConvertRequest() {
    }

    /**
     * Creates a ConvertRequest with the supplied source and target.
     *
     * @param source The source
     * @param target The target
     */
    public ConvertRequest(Document source, Document target) {
        this.source = source;
        this.target = target;
    }

    /**
     * Returns the source of the convert request.
     *
     * @return The source
     */
    public Document getSource() {
        return source;
    }

    /**
     * Sets the source of the convert request
     * @param value The source
     */
    public void setSource(Document value) {
        this.source = value;
    }

    /**
     * Returns the target of the convert request.
     *
     * @return The target
     */
    public Document getTarget() {
        return target;
    }

    /**
     * Sets the target of the convert request
     * @param value The target
     */
    public void setTarget(Document value) {
        this.target = value;
    }
}
