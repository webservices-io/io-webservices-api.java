package io.webservices.api.document.model.merge;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.webservices.api.document.model.Document;
import io.webservices.api.document.model.WebservicesRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a merge request.
 *
 * @author Rintcius Blok
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("mergeRequest")
public class MergeRequest implements WebservicesRequest {

    /**
     * The template of the merge request.
     */
    private Document template;

    /**
     * The map of variables and their values to be used to generate the target document from the template.
     */
    private Map<String, String> data = new HashMap<String, String>();

    /**
     * The target document of the merge request specifying where or how the generated document will be returned.
     */
    private Document target;

    /**
     * Creates a MergeRequest.
     */
    public MergeRequest() {
    }

    /**
     * Creates a MergeRequest with the supplied template, data map and target.
     *
     * @param template The template
     * @param data The data map
     * @param target The target
     */
    public MergeRequest(Document template, Map<String, String> data, Document target) {
        this.template = template;
        this.data = data;
        this.target = target;
    }

    /**
     * Returns the template of the merge request.
     *
     * @return The template
     */
    public Document getTemplate() {
        return template;
    }

    /**
     * Sets the template of the merge request.
     *
     * @param template The template
     */
    public void setTemplate(Document template) {
        this.template = template;
    }

    /**
     * Returns the data map of the merge request.
     *
     * @return The data map
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Sets the data map of the merge request.
     *
     * @param data The data map
     */
    public void setData(Map<String, String> data) {
        this.data = data;
    }

    /**
     * Returns the target of the merge request.
     *
     * @return The target
     */
    public Document getTarget() {
        return target;
    }

    /**
     * Sets the target of the merge request.
     *
     * @param target The target
     */
    public void setTarget(Document target) {
        this.target = target;
    }
}
