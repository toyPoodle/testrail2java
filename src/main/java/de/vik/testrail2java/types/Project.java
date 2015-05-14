package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Project {
    private String announcement;
    private Timestamp completedOn;
    private ProjectId id;
    private boolean isCompleted;
    private String name;
    private boolean showAnnouncement;
    private SuiteMode suiteMode;
    private String url;

    public Project(String announcement, Timestamp completedOn, ProjectId id, boolean isCompleted, String name, boolean showAnnouncement, SuiteMode suiteMode, String url) {
        this.announcement = announcement;
        this.completedOn = completedOn;
        this.id = id;
        this.isCompleted = isCompleted;
        this.name = name;
        this.showAnnouncement = showAnnouncement;
        this.suiteMode = suiteMode;
        this.url = url;
    }

    /**
     * The description/announcement of the project
     */
    public String getAnnouncement() {
        return announcement;
    }

    /**
     * The date/time when the project was marked as completed
     */
    public Timestamp getCompletedOn() {
        return completedOn;
    }

    /**
     * The unique ID of the project
     */
    public ProjectId getId() {
        return id;
    }

    /**
     * True if the project is marked as completed and false otherwise
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * The name of the project
     */
    public String getName() {
        return name;
    }

    /**
     * True to show the announcement/description and false otherwise
     */
    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    /**
     * The suite mode of the project. (added with TestRail 4.0)
     */
    public SuiteMode getSuiteMode() {
        return suiteMode;
    }

    /**
     * The address/URL of the project in the user interface
     */
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Project{" +
                "announcement='" + announcement + '\'' +
                ", completedOn=" + completedOn +
                ", id=" + id +
                ", isCompleted=" + isCompleted +
                ", name='" + name + '\'' +
                ", showAnnouncement=" + showAnnouncement +
                ", suiteMode=" + suiteMode +
                ", url='" + url + '\'' +
                '}';
    }

    public static class ProjectId extends NumericId {
        public ProjectId(int id) {
            super(id);
        }
    }
}
