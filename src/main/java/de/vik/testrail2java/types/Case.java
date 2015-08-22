package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.custom.Step;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.TimeSpan;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Case {
    private final UserId createdBy;
    private final Timestamp createdOn;
    private final TimeSpan estimate;
    private final TimeSpan estimateForecast;
    private final CaseId id;
    private final MilestoneId milestoneId;
    private final PriorityId priorityId;
    private final String refs;
    private final SectionId sectionId;
    private final SuiteId suiteId;
    private final String title;
    private final TypeId typeId;
    private final UserId updatedBy;
    private final Timestamp updatedOn;
    private final List<Step> customStepsSeparated;
    @SuppressWarnings("SpellCheckingInspection")
    private final String customPreconds;
    @SuppressWarnings("SpellCheckingInspection")
    private final String customTestdata;

    /**
     * For Tests
     */
    Case(UserId createdBy, Timestamp createdOn, TimeSpan estimate, TimeSpan estimateForecast, CaseId id, MilestoneId milestoneId,
                PriorityId priorityId, String refs, SectionId sectionId, SuiteId suiteId, String title, TypeId typeId, UserId updatedBy,
                Timestamp updatedOn, List<Step> steps, String precondition, String testData) {
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
        this.customStepsSeparated = new ArrayList<>(steps);
        this.customPreconds = precondition;
        this.customTestdata = testData;
    }

    public Case(SectionId sectionId, String title, TypeId typeId, PriorityId priorityId, TimeSpan estimate, MilestoneId milestoneId,
                String refs, List<Step> steps, String precondition, String testData) {
        this(null, null, estimate, null, null, milestoneId, priorityId, refs, sectionId, null, title, typeId, null, null, steps, precondition, testData);
    }

    /**
     * @return The ID of the user who created the test case
     */
    public UserId getCreatedBy() {
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
    public PriorityId getPriorityId() {
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
    public SuiteId getSuiteId() {
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
    public UserId getUpdatedBy() {
        return updatedBy;
    }

    /**
     *
     * @return The date/time when the test case was last updated (as UNIX timestamp)
     */
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public String getPreconditions() {
        return customPreconds;
    }

    public String getTestData() {
        return customTestdata;
    }

    public List<Step> getSteps() {
        return customStepsSeparated;
    }

    @Override
    public String toString() {
        //noinspection SpellCheckingInspection
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
