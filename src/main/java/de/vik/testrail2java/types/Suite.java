package de.vik.testrail2java.types;

import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Suite {
    private Timestamp completedOn;
    private String description;
    private SuiteId id;
    private boolean isBaseline;
    private boolean isCompleted;
    private boolean isMaster;
    private String name;
    private ProjectId projectId;
    private String url;

    /**
     * For tests
     */
    Suite(Timestamp completedOn, String description, SuiteId id, boolean isBaseLine, boolean isCompleted,
                 boolean isMaster, String name, ProjectId projectId, String url) {
        this.completedOn = completedOn;
        this.description = description;
        this.id = id;
        this.isBaseline = isBaseLine;
        this.isCompleted = isCompleted;
        this.isMaster = isMaster;
        this.name = name;
        this.projectId = projectId;
        this.url = url;
    }

    public Suite(String description, String name, ProjectId projectId) {
        this.description = description;
        this.name = name;
        this.projectId = projectId;
    }

    public Timestamp getCompletedOn() {
        return completedOn;
    }

    public String getDescription() {
        return description;
    }

    public SuiteId getId() {
        return id;
    }

    public boolean isBaseLine() {
        return isBaseline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public String getName() {
        return name;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Suite{" +
                "completedOn=" + completedOn +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", isBaseline=" + isBaseline +
                ", isCompleted=" + isCompleted +
                ", isMaster=" + isMaster +
                ", name='" + name + '\'' +
                ", projectId=" + projectId +
                ", url='" + url + '\'' +
                '}';
    }

    public static class SuiteId extends NumericId {
        public SuiteId(int id) {
            super(id);
        }
    }
}
