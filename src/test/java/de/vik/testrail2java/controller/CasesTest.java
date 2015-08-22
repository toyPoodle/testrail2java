package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.Suite.SuiteId;

import static de.vik.testrail2java.controller.Cases.CaseFilter.bySuiteId;
import static de.vik.testrail2java.net.Filters.filter;
import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static de.vik.testrail2java.types.primitive.Primitives.caseId;
import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.sectionId;
import static org.mockito.Mockito.when;

public class CasesTest {

    @Test
    public void getCase() throws Exception {
        testGetItem(Case.class, "get_case/1",
                (client) -> new Cases(client).getCase(caseId(1)));
    }

    @Test
    public void getCases() throws Exception {
        testGetList(Case.class, "get_cases/1&suite_id=2", (client) -> {
            Cases target = new Cases(client);
            return target.getCases(projectId(1), filter(bySuiteId(new SuiteId(2))));
        });
    }

    @Test
    public void addCase() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Case.class, "title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata");
        testSubmissionWithData("add_case/1", Case.class, allowedFields,
                (theCase) -> when(theCase.getSectionId()).thenReturn(sectionId(1)),
                (apiClient, theCase) -> new Cases(apiClient).addCase(theCase));
    }

    @Test
    public void updateCase() throws Exception {
        @SuppressWarnings("SpellCheckingInspection")
        final AllowedFields allowedFields = new AllowedFields(Case.class, "title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata");
        testSubmissionWithData("update_case/1", Case.class, allowedFields,
                (data) -> when(data.getId()).thenReturn(caseId(1)),
                (apiClient, data) -> new Cases(apiClient).updateCase(data));
    }

    @Test
    public void deleteCase() throws Exception {
        testSubmissionWithoutResultAndData("delete_case/1",
                (apiClient) -> new Cases(apiClient).deleteCase(caseId(1)));
    }
}