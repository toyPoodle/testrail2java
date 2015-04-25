package de.vik.testrail2java.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.testhelpers.MoreMatchers;
import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.Suite;
import de.vik.testrail2java.testhelpers.Mockups;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section.SectionId;

import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static de.vik.testrail2java.controller.Cases.CaseFilter.suiteId;

public class CasesTest {

    @Test
    public void getCase() throws Exception {
        Case expected = mock(Case.class);
        Cases target = new Cases(Mockups.apiClientGET(Case.class, "get_case/1", expected));
        assertThat(target.getCase(new Case.CaseId(1)), sameInstance(expected));
    }

    @Test
    public void getCases() throws Exception {
        List<Case> expected = new ArrayList<Case>();
        Cases target = new Cases(Mockups.apiClientGET(Case.class, "get_cases/1&suite_id=2", expected));
        final List<Case> actual = target.getCases(new ProjectId(1), Filters.filterBy(suiteId(new Suite.SuiteId(2))));
        assertThat(actual, sameInstance(expected));
    }

    @Test
    public void addCase() throws Exception {
        Case expected = mock(Case.class);
        Case submittedData = mock(Case.class);
        final String[] allowedFields = {"title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata"};

        APIClient apiClient = mock(APIClient.class);
        when(apiClient.post(MoreMatchers.uri("add_case/1"), eq(submittedData), eq(allowedFields), eq(Case.class))).thenReturn(expected);
        Cases target = new Cases(apiClient);

        final Case actual = target.addCase(new SectionId(1), submittedData);

        assertThat(actual, sameInstance(expected));
        verify(apiClient, times(1)).post(MoreMatchers.uri("add_case/1"), eq(submittedData), eq(allowedFields), eq(Case.class));
    }

    @Test
    public void updateCase() throws Exception {
        Case expected = mock(Case.class);
        Case submittedData = mock(Case.class);
        when(submittedData.getId()).thenReturn(new Case.CaseId(1));
        final String[] allowedFields = {"title", "typeId", "priorityId", "estimate", "milestoneId", "refs",
                "customStepsSeparated", "customPreconds", "customTestdata"};
        APIClient apiClient = mock(APIClient.class);
        when(apiClient.post(MoreMatchers.uri("update_case/1"), eq(submittedData), eq(allowedFields), eq(Case.class))).thenReturn(expected);
        Cases target = new Cases(apiClient);

        final Case actual = target.updateCase(submittedData);

        assertThat(actual, sameInstance(expected));
        verify(apiClient, times(1)).post(MoreMatchers.uri("update_case/1"), eq(submittedData), eq(allowedFields), eq(Case.class));
    }

    @Test
    public void deleteCase() throws Exception {
        APIClient client = mock(APIClient.class);
        Cases target = new Cases(client);

        target.deleteCase(new Case.CaseId(1));

        verify(client, times(1)).post(MoreMatchers.uri("delete_case/1"));
    }
}