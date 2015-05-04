package de.vik.testrail2java.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.testhelpers.Mockups;
import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Suite;

import static de.vik.testrail2java.controller.Cases.CaseFilter.suiteId;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasesTest {

    @Test
    public void getCase() throws Exception {
        Case expected = mock(Case.class);
        Cases target = new Cases(Mockups.apiClientGET(Case.class, "get_case/1", expected));
        assertThat(target.getCase(new Case.CaseId(1)), sameInstance(expected));
    }

    @Test
    public void getCases() throws Exception {
        List<Case> expected = new ArrayList<>();
        Cases target = new Cases(Mockups.apiClientGET(Case.class, "get_cases/1&suite_id=2", expected));
        final List<Case> actual = target.getCases(new ProjectId(1), Filters.filterBy(suiteId(new Suite.SuiteId(2))));
        assertThat(actual, sameInstance(expected));
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