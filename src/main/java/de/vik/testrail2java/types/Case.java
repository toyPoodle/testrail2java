package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.custom.Step;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.TimeSpan;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Case {
    private User.UserId createdBy;
    private Timestamp createdOn;
    private TimeSpan estimate;
    private TimeSpan estimateForecast;
    private CaseId id;
    private MilestoneId milestoneId;
    private Priority.PriorityId priorityId;
    private String refs;
    private SectionId sectionId;
    private Suite.SuiteId suiteId;
    private String title;
    private TypeId typeId;
    private User.UserId updatedBy;
    private Timestamp updatedOn;
    private List<Step> customStepsSeparated;
    private String customPreconds;
    private String customTestdata;

    public Case(User.UserId createdBy, Timestamp createdOn, TimeSpan estimate, TimeSpan estimateForecast, CaseId id, MilestoneId milestoneId, Priority.PriorityId priorityId, String refs, SectionId sectionId, Suite.SuiteId suiteId, String title, TypeId typeId, User.UserId updatedBy, Timestamp updatedOn, List<Step> customStepsSeparated, String customPreconds, String customTestdata) {
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.estimate = estimate;
        this.estimateForecast = estimateForecast;
        this.id = id;
        this.milestoneId = milestoneId;
        this.priorityId = priorityId;
        this.refs = refs;
        this.sectionId = sectionId;
        this.suiteId = suiteId;
        this.title = title;
        this.typeId = typeId;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.customStepsSeparated = new ArrayList<Step>(customStepsSeparated);
        this.customPreconds = customPreconds;
        this.customTestdata = customTestdata;
    }

    /**
     * @return The ID of the user who created the test case
     */
    public User.UserId getCreatedBy() {
        return createdBy;
    }

    /**
     * @return The date/time when the test case was created (as UNIX timestamp)
     */
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    /**
     * @return The estimate, e.g. "30s" or "1m 45s"
     */
    public TimeSpan getEstimate() {
        return estimate;
    }

    /**
     *
     * @return The estimate forecast, e.g. "30s" or "1m 45s"
     */
    public TimeSpan getEstimateForecast() {
        return estimateForecast;
    }

    /**
     *
     * @return The unique ID of the test case
     */
    public CaseId getId() {
        return id;
    }

    /**
     *
     * @return The ID of the milestone that is linked to the test case
     */
    public MilestoneId getMilestoneId() {
        return milestoneId;
    }

    /**
     *
     * @return The ID of the priority that is linked to the test case
     */
    public Priority.PriorityId getPriorityId() {
        return priorityId;
    }

    /**
     *
     * @return A comma-separated list of references/requirements
     */
    public String getRefs() {
        return refs;
    }

    /**
     *
     * @return The ID of the section the test case belongs to
     */
    public SectionId getSectionId() {
        return sectionId;
    }

    /**
     *
     * @return The ID of the suite the test case belongs to
     */
    public Suite.SuiteId getSuiteId() {
        return suiteId;
    }

    /**
     *
     * @return The title of the test case
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return The ID of the test case type that is linked to the test case
     */
    public TypeId getTypeId() {
        return typeId;
    }

    /**
     *
     * @return The ID of the user who last updated the test case
     */
    public User.UserId getUpdatedBy() {
        return updatedBy;
    }

    /**
     *
     * @return The date/time when the test case was last updated (as UNIX timestamp)
     */
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public String getCustomPreconds() {
        return customPreconds;
    }

    public String getCustomTestdata() {
        return customTestdata;
    }

    public List<Step> getCustomStepsSeparated() {
        return customStepsSeparated;
    }

    @Override
    public String toString() {
        return "Case{" +
                "createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", estimate=" + estimate +
                ", estimateForecast=" + estimateForecast +
                ", id=" + id +
                ", milestoneId=" + milestoneId +
                ", priorityId=" + priorityId +
                ", refs='" + refs + '\'' +
                ", sectionId=" + sectionId +
                ", suiteId=" + suiteId +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                ", customStepsSeparated=" + customStepsSeparated +
                ", customPreconds='" + customPreconds + '\'' +
                ", customTestdata='" + customTestdata + '\'' +
                '}';
    }

    public static class CaseId extends NumericId {
        public CaseId(int id) {
            super(id);
        }
    }
}
