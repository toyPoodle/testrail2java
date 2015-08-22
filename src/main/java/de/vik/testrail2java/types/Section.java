package de.vik.testrail2java.types;

import de.vik.testrail2java.controller.Sections;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.primitive.NumericId;

public class Section {
    private final int depth;
    private final String description;
    private final int displayOrder;
    private final SectionId id;
    private final SectionId parentId;
    private final String name;
    private final SuiteId suiteId;

    /**
     * For tests
     */
    Section(int depth, String description, int displayOrder, SectionId id, SectionId parentId, String name, SuiteId suiteId) {
        this.depth = depth;
        this.description = description;
        this.displayOrder = displayOrder;
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.suiteId = suiteId;
    }

    public Section(String description, SuiteId suiteId, SectionId parentId, String name) {
        this(0, description, 0, null, parentId, name, suiteId);
    }

    /**
     * The level in the section hierarchy of the test suite.
     *
     * The {@link #depth}, {@link #displayOrder} and {@link #parentId} fields determine the hierarchy of the sections in a test
     * suite. The {@link #depth} field is 0 for all sections on the root level and greater than 0 for all child sections.
     * The {@link #depth} field therefore resembles the level in the section hierarchy. Also see {@link Sections#getSections} for an example.
     */
    public int getDepth() {
        return depth;
    }

    /**
     *The description of the section (added with TestRail 4.0)
     */
    public String getDescription() {
        return description;
    }

    /**
     *The order in the test suite
     *
     * The {@link #depth}, {@link #displayOrder} and {@link #parentId} fields determine the hierarchy of the sections in a test
     * suite. The {@link #depth} field is 0 for all sections on the root level and greater than 0 for all child sections.
     * The {@link #depth} field therefore resembles the level in the section hierarchy. Also see {@link Sections#getSections} for an example.
     */
    public int getDisplayOrder() {
        return displayOrder;
    }

    /**
     *The unique ID of the section
     */
    public SectionId getId() {
        return id;
    }

    /**
     *The ID of the parent section in the test suite
     *
     * The {@link #depth}, {@link #displayOrder} and {@link #parentId} fields determine the hierarchy of the sections in a test
     * suite. The {@link #depth} field is 0 for all sections on the root level and greater than 0 for all child sections.
     * The {@link #depth} field therefore resembles the level in the section hierarchy. Also see {@link Sections#getSections} for an example.
     */
    public SectionId getParentId() {
        return parentId;
    }

    /**
     * The name of the section
     */
    public String getName() {
        return name;
    }

    /**
     *The ID of the test suite this section belongs to
     */
    public SuiteId getSuiteId() {
        return suiteId;
    }

    @Override
    public String toString() {
        return "Section{" +
                "depth=" + depth +
                ", description='" + description + '\'' +
                ", displayOrder=" + displayOrder +
                ", id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", suiteId=" + suiteId +
                '}';
    }

    public static class SectionId extends NumericId {
        public SectionId(int id) {
            super(id);
        }
    }
}
