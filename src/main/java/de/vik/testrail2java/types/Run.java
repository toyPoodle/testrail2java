package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.ConfigurationGroup.ConfigurationId;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Plan.PlanEntryId;
import de.vik.testrail2java.types.Plan.PlanId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Run {
    @SuppressWarnings("SpellCheckingInspection")
    private UserId assignedtoId;
    private int blockedCount;
    private Timestamp completedOn;
    private String config;
    private List<ConfigurationId> configIds;
    private UserId createdBy;
    private Timestamp createdOn;
    private int customStatus1Count;
    private int customStatus2Count;
    private int customStatus3Count;
    private int customStatus4Count;
    private int customStatus5Count;
    private int customStatus6Count;
    private int customStatus7Count;
    private String description;
    private int failedCount;
    private RunId id;
    private boolean includeAll;
    private boolean isCompleted;
    private MilestoneId milestoneId;
    private PlanId planId;
    private String name;
    private int passedCount;
    private ProjectId projectId;
    private int retestCount;
    private SuiteId suiteId;
    private int untestedCount;
    private String url;
    private int entryIndex;
    private PlanEntryId entryId;
    private List<CaseId> caseIds;

    @SuppressWarnings({"BooleanParameter", "SpellCheckingInspection"})
    public Run(UserId assignedtoId, int blockedCount, Timestamp completedOn, String config, List<ConfigurationId> configIds,
               UserId createdBy, Timestamp createdOn, int customStatus1Count, int customStatus2Count, int customStatus3Count,
               int customStatus4Count, int customStatus5Count, int customStatus6Count, int customStatus7Count, String description,
               int failedCount, RunId id, boolean includeAll, boolean isCompleted, MilestoneId milestoneId, PlanId planId,
               String name, int passedCount, ProjectId projectId, int retestCount, SuiteId suiteId, int untestedCount,
               String url, int entryIndex, PlanEntryId entryId, List<CaseId> caseIds) {
        this.assignedtoId = assignedtoId;
        this.blockedCount = blockedCount;
        this.completedOn = completedOn;
        this.config = config;
        this.configIds = new ArrayList<>(configIds);
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.customStatus1Count = customStatus1Count;
        this.customStatus2Count = customStatus2Count;
        this.customStatus3Count = customStatus3Count;
        this.customStatus4Count = customStatus4Count;
        this.customStatus5Count = customStatus5Count;
        this.customStatus6Count = customStatus6Count;
        this.customStatus7Count = customStatus7Count;
        this.description = description;
        this.failedCount = failedCount;
        this.id = id;
        this.includeAll = includeAll;
        this.isCompleted = isCompleted;
        this.milestoneId = milestoneId;
        this.planId = planId;
        this.name = name;
        this.passedCount = passedCount;
        this.projectId = projectId;
        this.retestCount = retestCount;
        this.suiteId = suiteId;
        this.untestedCount = untestedCount;
        this.url = url;
        this.entryIndex = entryIndex;
        this.entryId = entryId;
        this.caseIds = new ArrayList<>(caseIds);
    }

    /**
     * The ID of the user the entire test run is assigned to
     */
    public UserId getAssignedToId() {
        return assignedtoId;
    }

    /**
     * The amount of tests in the test run marked as blocked
     */
    public int getBlockedCount() {
        return blockedCount;
    }

    /**
     * The date/time when the test run was closed (as UNIX timestamp)
     */
    public Timestamp getCompletedOn() {
        return completedOn;
    }

    /**
     * The configuration of the test run as string (if part of a test plan)
     */
    public String getConfig() {
        return config;
    }

    /**
     * The array of IDs of the configurations of the test run (if part of a test plan)
     */
    public List<ConfigurationId> getConfigIds() {
        return new ArrayList<>(configIds);
    }

    /**
     * The ID of the user who created the test run
     */
    public UserId getCreatedBy() {
        return createdBy;
    }

    /**
     * The date/time when the test run was created (as UNIX timestamp)
     */
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus1Count() {
        return customStatus1Count;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus2Count() {
        return customStatus2Count;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus3Count() {
        return customStatus3Count;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus4Count() {
        return customStatus4Count;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus5Count() {
        return customStatus5Count;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus6Count() {
        return customStatus6Count;
    }

    /**
     * The amount of tests in the test run with the respective custom status
     */
    public int getCustomStatus7Count() {
        return customStatus7Count;
    }

    /**
     * The description of the test run
     */
    public String getDescription() {
        return description;
    }

    /**
     * The amount of tests in the test run marked as failed
     */
    public int getFailedCount() {
        return failedCount;
    }

    /**
     * The unique ID of the test run
     */
    public RunId getId() {
        return id;
    }

    /**
     * True if the test run includes all test cases and false otherwise
     */
    public boolean isIncludeAll() {
        return includeAll;
    }

    /**
     * True if the test run was closed and false otherwise
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * The ID of the milestone this test run belongs to
     */
    public MilestoneId getMilestoneId() {
        return milestoneId;
    }

    /**
     * The ID of the test plan this test run belongs to
     */
    public PlanId getPlanId() {
        return planId;
    }

    /**
     * The name of the test run
     */
    public String getName() {
        return name;
    }

    /**
     * The amount of tests in the test run marked as passed
     */
    public int getPassedCount() {
        return passedCount;
    }

    /**
     * The ID of the project this test run belongs to
     */
    public ProjectId getProjectId() {
        return projectId;
    }

    /**
     * The amount of tests in the test run marked as retest
     */
    public int getRetestCount() {
        return retestCount;
    }

    /**
     * The ID of the test suite this test run is derived from
     */
    public SuiteId getSuiteId() {
        return suiteId;
    }

    /**
     * The amount of tests in the test run marked as untested
     */
    public int getUntestedCount() {
        return untestedCount;
    }

    /**
     * The address/URL of the test run in the user interface
     */
    public String getUrl() {
        return url;
    }

    /**
     * Position of the plan entry in the test plan if part of a test plan
     */
    public int getEntryIndex() {
        return entryIndex;
    }

    /**
     * A plan entry id if part of a test plan
     */
    public PlanEntryId getEntryId() {
        return entryId;
    }

    /**
     * An array of case IDs for the custom case selection
     */
    public List<CaseId> getCaseIds() {
        return caseIds;
    }

    @Override
    public String toString() {
        //noinspection SpellCheckingInspection
        return "Run{" +
                "assignedtoId=" + assignedtoId +
                ", blockedCount=" + blockedCount +
                ", completedOn=" + completedOn +
                ", config='" + config + '\'' +
                ", configIds=" + configIds +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", customStatus1Count=" + customStatus1Count +
                ", customStatus2Count=" + customStatus2Count +
                ", customStatus3Count=" + customStatus3Count +
                ", customStatus4Count=" + customStatus4Count +
                ", customStatus5Count=" + customStatus5Count +
                ", customStatus6Count=" + customStatus6Count +
                ", customStatus7Count=" + customStatus7Count +
                ", description='" + description + '\'' +
                ", failedCount=" + failedCount +
                ", id=" + id +
                ", includeAll=" + includeAll +
                ", isCompleted=" + isCompleted +
                ", milestoneId=" + milestoneId +
                ", planId=" + planId +
                ", name='" + name + '\'' +
                ", passedCount=" + passedCount +
                ", projectId=" + projectId +
                ", retestCount=" + retestCount +
                ", suiteId=" + suiteId +
                ", untestedCount=" + untestedCount +
                ", url='" + url + '\'' +
                ", entryIndex=" + entryIndex +
                ", entryId=" + entryId +
                ", caseIds=" + caseIds +
                '}';
    }

    public static class RunId extends NumericId {
        public RunId(int id) {
            super(id);
        }
    }
}
