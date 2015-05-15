package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Project;

import static de.vik.testrail2java.controller.Projects.ProjectFilter.isCompleted;
import static de.vik.testrail2java.net.Filters.filterBy;
import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static org.mockito.Mockito.when;

public class ProjectsTest {

    @Test
    public void testGetProject() throws Exception {
        testGetItem(Project.class, "get_project/1",
                client -> new Projects(client).getProject(projectId(1)));
    }

    @Test
    public void testGetProjects() throws Exception {
        testGetList(Project.class, "get_projects&is_completed=1",
                client -> new Projects(client).getProjects(filterBy(isCompleted())));
    }

    @Test
    public void testAddProject() throws Exception {
        final AllowedFields allowedFields = new AllowedFields(Project.class, "name", "announcement", "showAnnouncement", "suiteMode");
        testSubmissionWithData("add_project", Project.class, allowedFields,
                project -> {},
                (client, project) -> new Projects(client).addProject(project));
    }

    @Test
    public void testUpdateProject() throws Exception {
        final AllowedFields allowedFields = new AllowedFields(Project.class, "name", "announcement", "showAnnouncement", "suiteMode", "isCompleted");
        testSubmissionWithData("update_project/1", Project.class, allowedFields,
                project -> when(project.getId()).thenReturn(projectId(1)),
                (client, project) -> new Projects(client).updateProject(project));
    }

    @Test
    public void testDeleteProject() throws Exception {
        testSubmissionWithoutResultAndData("delete_project/1",
                client -> new Projects(client).deleteProject(projectId(1)));
    }
}