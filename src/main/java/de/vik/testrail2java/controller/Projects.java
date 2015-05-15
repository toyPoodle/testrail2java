package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.Filter;
import de.vik.testrail2java.net.Filters;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Project;
import de.vik.testrail2java.types.Project.ProjectId;

/**
 * http://docs.gurock.com/testrail-api2/reference-projects
 */
public class Projects {

    private APIClient client;

    public Projects(APIClient client) {
        this.client = client;
    }

    /**
     * Returns an existing project.
     * @param id The ID of the project
     */
    public Project getProject(ProjectId id) {
        return client.get(Project.class, new MethodUri("get_project/:project_id").withParameters(id));
    }

    /**
     * Returns the list of available projects.
     */
    public List<Project> getProjects(Filters<Project> filters) {
        return client.getList(Project.class, new MethodUri("get_projects", filters));
    }

    /**
     * Creates a new project (admin status required).
     * @param project project to be added
     * @return If successful, this method returns the new project
     */
    public Project addProject(Project project) {
        final AllowedFields allowedFields = new AllowedFields(Project.class, "name", "announcement", "showAnnouncement", "suiteMode");
        return client.post(new MethodUri("add_project"), project, allowedFields, Project.class);
    }

    /**
     * Updates an existing project (admin status required)
     * @param project project to be updated
     * @return If successful, this method returns the updated project
     */
    public Project updateProject(Project project){
        final AllowedFields allowedFields = new AllowedFields(Project.class, "name", "announcement", "showAnnouncement", "suiteMode", "isCompleted");
        final MethodUri uri = new MethodUri("update_project/:project_id").withParameters(project.getId());
        return client.post(uri, project, allowedFields, Project.class);
    }

    /**
     * Deletes an existing project (admin status required).
     * @param id The ID of the project
     */
    public void deleteProject(ProjectId id) {
        client.post(new MethodUri("delete_project/:project_id").withParameters(id));
    }

    public static class ProjectFilter extends Filter<Project> {

        private ProjectFilter(String key, String value) {
            super(key, value);
        }

        /**
         * completed projects only
         */
        public static Filter<Project> isCompleted() {
            return new ProjectFilter("is_completed", "1");
        }

        /**
         * active projects only
         */
        public static Filter<Project> isActive() {
            return new ProjectFilter("is_completed", "0");
        }
    }

}
