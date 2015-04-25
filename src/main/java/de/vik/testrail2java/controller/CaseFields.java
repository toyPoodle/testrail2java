package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.types.CaseField;

/**
 * http://docs.gurock.com/testrail-api2/reference-cases-fields
 */
public class CaseFields {
    private final APIClient apiClient;

    public CaseFields(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * @return Returns a list of available test case custom fields.
     */
    public List<CaseField> getCaseFields() {
        return apiClient.getList(CaseField.class, new MethodUri("get_case_fields"));
    }
}
