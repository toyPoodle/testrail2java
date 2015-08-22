package de.vik.testrail2java.controller;

import java.util.List;

import de.vik.testrail2java.net.APIClient;
import de.vik.testrail2java.net.MethodUri;
import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Suite.SuiteId;

/**
 * http://docs.gurock.com/testrail-api2/reference-sections
 */
public class Sections {
    private final APIClient client;

    public Sections(APIClient client) {
        this.client = client;
    }

    /**
     * Returns an existing section.
     * @param id The ID of the section
     */
    public Section getSection(SectionId id) {
        return client.get(Section.class, new MethodUri("get_section/:section_id").withParameters(id));
    }

    /**
     * Returns a list of sections for a project.
     * @param projectId The ID of the project
     */
    public List<Section> getSections(ProjectId projectId) {
        final MethodUri uri = new MethodUri("get_sections/:project_id").withParameters(projectId);
        return client.getList(Section.class, uri);
    }

    /**
     * Returns a list of sections for a project and test suite.
     * @param projectId The ID of the project
     * @param suiteId The ID of the test suite
     */
    public List<Section> getSections(ProjectId projectId, SuiteId suiteId) {
        final MethodUri uri = new MethodUri("get_sections/:project_id&suite_id=:suite_id").withParameters(projectId, suiteId);
        return client.getList(Section.class, uri);
    }

    /**
     * Creates a new section.
     * @param id The ID of the project
     * @param section Section to add
     * @return added section
     */
    public Section addSection(ProjectId id, Section section) {
        final MethodUri uri = new MethodUri("add_section/:project_id").withParameters(id);
        final AllowedFields allowedFields = new AllowedFields(Section.class, "description", "suiteId", "parentId", "name");
        return client.post(uri, section, allowedFields, Section.class);
    }

    /**
     * Updates an existing section
     * @param section section to update
     * @return updated section
     */
    public Section updateSection(Section section) {
        final MethodUri uri = new MethodUri("update_section/:section_id").withParameters(section.getId());
        final AllowedFields allowedFields = new AllowedFields(Section.class, "description", "name");
        return client.post(uri, section, allowedFields, Section.class);
    }

    /**
     * Deletes an existing section. Please note: Deleting a section cannot be undone and also deletes all related
     * test cases as well as active tests & results, i.e. tests & results that weren't closed (archived) yet.
     * @param id The ID of the section
     */
    public void deleteSection(SectionId id) {
        client.post(new MethodUri("delete_section/:section_id").withParameters(id));
    }
}
