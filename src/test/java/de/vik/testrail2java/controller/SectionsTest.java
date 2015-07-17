package de.vik.testrail2java.controller;

import org.junit.Test;

import de.vik.testrail2java.serialization.AllowedFields;
import de.vik.testrail2java.types.Section;

import static de.vik.testrail2java.testhelpers.Mockups.testGetItem;
import static de.vik.testrail2java.testhelpers.Mockups.testGetList;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithData;
import static de.vik.testrail2java.testhelpers.Mockups.testSubmissionWithoutResultAndData;
import static de.vik.testrail2java.types.primitive.Primitives.projectId;
import static de.vik.testrail2java.types.primitive.Primitives.sectionId;
import static de.vik.testrail2java.types.primitive.Primitives.suiteId;
import static org.mockito.Mockito.when;

public class SectionsTest {
    @Test
    public void testGetSection() throws Exception {
        testGetItem(Section.class, "get_section/1",
                apiClient -> new Sections(apiClient).getSection(sectionId(1)));
    }

    @Test
    public void testGetSections() throws Exception {
        testGetList(Section.class, "get_sections/2",
                apiClient -> new Sections(apiClient).getSections(projectId(2)));
    }

    @Test
    public void testGetSectionsWithSuite() throws Exception {
        testGetList(Section.class, "get_sections/2&suite_id=3",
                apiClient -> new Sections(apiClient).getSections(projectId(2), suiteId(3)));
    }

    @Test
    public void testAddSection() throws Exception {
        AllowedFields allowedFields = new AllowedFields(Section.class, "description", "suiteId", "parentId", "name");
        testSubmissionWithData("add_section/4", Section.class, allowedFields,
                section -> {},
                (apiClient, section) -> new Sections(apiClient).addSection(projectId(4), section));
    }

    @Test
    public void testUpdateSection() throws Exception {
        AllowedFields allowedFields = new AllowedFields(Section.class, "description", "name");
        testSubmissionWithData("update_section/5", Section.class, allowedFields,
                section -> when(section.getId()).thenReturn(sectionId(5)),
                (apiClient, section) -> new Sections(apiClient).updateSection(section));
    }

    @Test
    public void testDeleteSection() throws Exception {
        testSubmissionWithoutResultAndData("delete_section/6",
                apiClient -> new Sections(apiClient).deleteSection(sectionId(6)));
    }
}