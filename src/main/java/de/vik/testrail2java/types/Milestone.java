package de.vik.testrail2java.types;

import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Milestone {
    private final Timestamp completedOn;
    private final String description;
    private final Timestamp dueOn;
    private final MilestoneId id;
    private final boolean isCompleted;
    private final String name;
    private final ProjectId projectId;
    private final String url;

    /**
     * For tests
     */
    Milestone(Timestamp completedOn, String description, Timestamp dueOn, MilestoneId id, boolean isCompleted, String name,
              ProjectId projectId, String url) {
        this.completedOn = completedOn;
        this.description = description;
        this.dueOn = dueOn;
        this.id = id;
        this.isCompleted = isCompleted;
        this.name = name;
        this.projectId = projectId;
        this.url = url;
    }

    public Milestone(String description, String name, ProjectId projectId, Timestamp dueOn) {
        this(null, description, dueOn, null, false, name, projectId, null);
    }

    /**
     * The date/time when the milestone was marked as completed (as UNIX timestamp)
     */
    public Timestamp getCompletedOn() {
        return completedOn;
    }

    /**
     * The description of the milestone
     */
    public String getDescription() {
        return description;
    }

    /**
     *The due date/time of the milestone (as UNIX timestamp)
     */
    public Timestamp getDueOn() {
        return dueOn;
    }

    /**
     *The unique ID of the milestone
     */
    public MilestoneId getId() {
        return id;
    }

    /**
     *True if the milestone is marked as completed and false otherwise
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     *The name of the milestone
     */
    public String getName() {
        return name;
    }

    /**
     *The ID of the project the milestone belongs to
     */
    public ProjectId getProjectId() {
        return projectId;
    }

    /**
     *The address/URL of the milestone in the user interface
     */
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "completedOn=" + completedOn +
                ", description='" + description + '\'' +
                ", dueOn=" + dueOn +
                ", id=" + id +
                ", isCompleted=" + isCompleted +
                ", name='" + name + '\'' +
                ", projectId=" + projectId +
                ", url='" + url + '\'' +
                '}';
    }

    public static class MilestoneId extends NumericId {
        public MilestoneId(int id) {
            super(id);
        }
    }

}
