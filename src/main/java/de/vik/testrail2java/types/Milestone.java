package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Milestone {
    private Timestamp completedOn;
    private String description;
    private Timestamp dueOn;
    private MilestoneId id;
    private boolean isCompleted;
    private String name;
    private Project.ProjectId projectId;
    private String url;

    public Milestone(Timestamp completedOn, String description, Timestamp dueOn, MilestoneId id, boolean isCompleted, String name, Project.ProjectId projectId, String url) {
        this.completedOn = completedOn;
        this.description = description;
        this.dueOn = dueOn;
        this.id = id;
        this.isCompleted = isCompleted;
        this.name = name;
        this.projectId = projectId;
        this.url = url;
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
    public Project.ProjectId getProjectId() {
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
