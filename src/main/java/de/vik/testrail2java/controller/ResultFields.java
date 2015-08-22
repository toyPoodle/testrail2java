package de.vik.testrail2java.controller;


import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.CustomFieldDefinition;

/**
 * http://docs.gurock.com/testrail-api2/reference-results-fields
 */
public class ResultFields {

    private final APIClient client;

    public ResultFields(APIClient client) {
        this.client = client;
    }

    /**
     * Returns a list of available test result custom fields.
     */
    public List<CustomFieldDefinition> getResultFields() {
        return client.getList(CustomFieldDefinition.class, new MethodUri("get_result_fields"));
    }
}
