package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Suite.SuiteId;

import static de.vik.testrail2java.controller.Cases.CaseFilter.suiteId;
import static de.vik.testrail2java.net.Filters.filterBy;
import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static org.mockito.Mockito.when;

public class CasesTest {

    @Test
    public void getCase() throws Exception {
        testGetItem(Case.class, "get_case/1",
                (client) -> new Cases(client).getCase(new Case.CaseId(1)));
    }

    @Test
    public void getCases() throws Exception {
        testGetList(Case.class, "get_cases/1&suite_id=2", (client) -> {
            Cases target = new Cases(client);
            return target.getCases(new ProjectId(1), filterBy(suiteId(new SuiteId(2))));
        });
    }

    @Test
    public void addCase() throws Exception {
        final String[] allowedFields = {"title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata"};
        testSubmissionWithData("add_case/1", Case.class, allowedFields,
                (data) -> {},
                (apiClient, data) -> new Cases(apiClient).addCase(new SectionId(1), data));
    }

    @Test
    public void updateCase() throws Exception {
        final String[] allowedFields = {"title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata"};
        testSubmissionWithData("update_case/1", Case.class, allowedFields,
                (data) -> when(data.getId()).thenReturn(new Case.CaseId(1)),
                (apiClient, data) -> new Cases(apiClient).updateCase(data));
    }

    @Test
    public void deleteCase() throws Exception {
        testSubmissionWithoutResultAndData("delete_case/1",
                (apiClient) -> new Cases(apiClient).deleteCase(new Case.CaseId(1)));
    }
}