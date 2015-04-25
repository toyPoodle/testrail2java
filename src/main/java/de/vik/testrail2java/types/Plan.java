package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

public class Plan {

    private User.UserId assignedtoId;
    private int blockedCount;
    private Timestamp completedOn;
    private User.UserId createdBy;
    private Timestamp createdOn;
    private int customStatus1Count;
    private String description;
    private List<PlanEntry> entries;
    private int failedCount;
    private PlanId id;
    private boolean isCompleted;
    private Milestone.MilestoneId milestoneId;
    private String name;
    private int passedCount;
    private Project.ProjectId projectId;
    private int retestCount;
    private int untestedCount;
    private String url;

    public Plan(User.UserId assignedtoId, int blockedCount, Timestamp completedOn, User.UserId createdBy, Timestamp createdOn, int customStatus1Count, String description, List<PlanEntry> entries, int failedCount, PlanId id, boolean isCompleted, Milestone.MilestoneId milestoneId, String name, int passedCount, Project.ProjectId projectId, int retestCount, int untestedCount, String url) {
        this.assignedtoId = assignedtoId;
        this.blockedCount = blockedCount;
        this.completedOn = completedOn;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.customStatus1Count = customStatus1Count;
        this.description = description;
        this.entries = entries;
        this.failedCount = failedCount;
        this.id = id;
        this.isCompleted = isCompleted;
        this.milestoneId = milestoneId;
        this.name = name;
        this.passedCount = passedCount;
        this.projectId = projectId;
        this.retestCount = retestCount;
        this.untestedCount = untestedCount;
        this.url = url;
    }

    public User.UserId getAssignedtoId() {
        return assignedtoId;
    }

    public int getBlockedCount() {
        return blockedCount;
    }

    public Timestamp getCompletedOn() {
        return completedOn;
    }

    public User.UserId getCreatedBy() {
        return createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public int getCustomStatus1Count() {
        return customStatus1Count;
    }

    public String getDescription() {
        return description;
    }

    public List<PlanEntry> getEntries() {
        return entries;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public PlanId getId() {
        return id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Milestone.MilestoneId getMilestoneId() {
        return milestoneId;
    }

    public String getName() {
        return name;
    }

    public int getPassedCount() {
        return passedCount;
    }

    public Project.ProjectId getProjectId() {
        return projectId;
    }

    public int getRetestCount() {
        return retestCount;
    }

    public int getUntestedCount() {
        return untestedCount;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "assignedtoId=" + assignedtoId +
                ", blockedCount=" + blockedCount +
                ", completedOn=" + completedOn +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", customStatusCount=" + customStatus1Count +
                ", description='" + description + '\'' +
                ", entries=" + entries +
                ", failedCount=" + failedCount +
                ", id=" + id +
                ", isCompleted=" + isCompleted +
                ", milestoneId=" + milestoneId +
                ", name='" + name + '\'' +
                ", passedCount=" + passedCount +
                ", projectId=" + projectId +
                ", retestCount=" + retestCount +
                ", untestedCount=" + untestedCount +
                ", url='" + url + '\'' +
                '}';
    }

    public static class PlanId extends NumericId {
        public PlanId(int id) {
            super(id);
        }
    }

    public static class PlanEntry {
        private PlanEntryId id;
        private String name;
        private Suite.SuiteId suiteId;
        private List<TestRun> runs;
        private List<ConfigurationGroup.ConfigurationId> configIds;
        private boolean includeAll;
        private User.UserId assignedtoId;

        public PlanEntry(PlanEntryId id, String name, Suite.SuiteId suiteId, List<TestRun> runs, List<ConfigurationGroup.ConfigurationId> configIds, boolean includeAll, User.UserId assignedtoId) {
            this.id = id;
            this.name = name;
            this.suiteId = suiteId;
            this.runs = runs;
            this.configIds = configIds;
            this.includeAll = includeAll;
            this.assignedtoId = assignedtoId;
        }

        public PlanEntryId getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Suite.SuiteId getSuiteId() {
            return suiteId;
        }

        public List<TestRun> getRuns() {
            return runs;
        }

        public List<ConfigurationGroup.ConfigurationId> getConfigIds() {
            return configIds;
        }

        public boolean isIncludeAll() {
            return includeAll;
        }

        public User.UserId getAssignedtoId() {
            return assignedtoId;
        }

        @Override
        public String toString() {
            return "PlanEntry{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", suiteId=" + suiteId +
                    ", runs=" + runs +
                    ", configIds=" + configIds +
                    ", includeAll=" + includeAll +
                    ", assignedtoId=" + assignedtoId +
                    '}';
        }
    }

    public static class TestRun {
        private TestRunId id;
        private Suite.SuiteId suiteId;
        private boolean includeAll;
        private boolean isCompleted;
        private int passedCount;
        private int blockedCount;
        private int failedCount;
        private int untestedCount;
        private int retestCount;
        private Project.ProjectId projectId;
        private PlanId planId;
        private int entryIndex;
        private PlanEntryId entryId;
        private List<Case.CaseId> caseIds;
        private User.UserId assignedtoId;
        private List<ConfigurationGroup.ConfigurationId> configIds;
        private String name;

        public TestRun(TestRunId id, Suite.SuiteId suiteId, boolean includeAll, boolean isCompleted, int passedCount, int blockedCount, int failedCount, int untestedCount, int retestCount, Project.ProjectId projectId, PlanId planId, int entryIndex, PlanEntryId entryId, List<Case.CaseId> caseIds, User.UserId assignedtoId, List<ConfigurationGroup.ConfigurationId> configIds, String name) {
            this.id = id;
            this.suiteId = suiteId;
            this.includeAll = includeAll;
            this.isCompleted = isCompleted;
            this.passedCount = passedCount;
            this.blockedCount = blockedCount;
            this.failedCount = failedCount;
            this.untestedCount = untestedCount;
            this.retestCount = retestCount;
            this.projectId = projectId;
            this.planId = planId;
            this.entryIndex = entryIndex;
            this.entryId = entryId;
            this.caseIds = caseIds;
            this.assignedtoId = assignedtoId;
            this.configIds = configIds;
            this.name = name;
        }

        public TestRunId getId() {
            return id;
        }

        public Suite.SuiteId getSuiteId() {
            return suiteId;
        }

        public boolean isIncludeAll() {
            return includeAll;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public int getPassedCount() {
            return passedCount;
        }

        public int getBlockedCount() {
            return blockedCount;
        }

        public int getFailedCount() {
            return failedCount;
        }

        public int getUntestedCount() {
            return untestedCount;
        }

        public int getRetestCount() {
            return retestCount;
        }

        public Project.ProjectId getProjectId() {
            return projectId;
        }

        public PlanId getPlanId() {
            return planId;
        }

        public int getEntryIndex() {
            return entryIndex;
        }

        public PlanEntryId getEntryId() {
            return entryId;
        }

        public List<Case.CaseId> getCaseIds() {
            return new ArrayList<Case.CaseId>(caseIds);
        }

        public User.UserId getAssignedtoId() {
            return assignedtoId;
        }

        public List<ConfigurationGroup.ConfigurationId> getConfigIds() {
            return new ArrayList<ConfigurationGroup.ConfigurationId>(configIds);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "TestRun{" +
                    "id=" + id +
                    ", suiteId=" + suiteId +
                    ", includeAll=" + includeAll +
                    ", isCompleted=" + isCompleted +
                    ", passedCount=" + passedCount +
                    ", blockedCount=" + blockedCount +
                    ", failedCount=" + failedCount +
                    ", untestedCount=" + untestedCount +
                    ", retestCount=" + retestCount +
                    ", projectId=" + projectId +
                    ", planId=" + planId +
                    ", entryIndex=" + entryIndex +
                    ", entryId='" + entryId + '\'' +
                    ", caseIds=" + caseIds +
                    ", assignedtoId=" + assignedtoId +
                    ", configIds=" + configIds +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class TestRunId extends NumericId {
        public TestRunId(int id) {
            super(id);
        }
    }

    public static class PlanEntryId extends Id {
        public PlanEntryId(String id) {
            super(id);
        }
    }
}
