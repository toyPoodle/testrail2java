package de.vik.testrail2java.types;

import java.util.List;

import de.vik.testrail2java.types.ConfigurationGroup.ConfigurationId;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.Timestamp;

import static de.vik.testrail2java.utilities.ListUtils.copy;

public class Plan {

    @SuppressWarnings("SpellCheckingInspection")
    private final UserId assignedtoId;
    private final int blockedCount;
    private final Timestamp completedOn;
    private final UserId createdBy;
    private final Timestamp createdOn;
    private final int customStatus1Count;
    private final String description;
    private final List<PlanEntry> entries;
    private final int failedCount;
    private final PlanId id;
    private final boolean isCompleted;
    private final MilestoneId milestoneId;
    private final String name;
    private final int passedCount;
    private final ProjectId projectId;
    private final int retestCount;
    private final int untestedCount;
    private final String url;

    @SuppressWarnings("BooleanParameter")
    public Plan(UserId assignedToId, int blockedCount, Timestamp completedOn, UserId createdBy, Timestamp createdOn,
                int customStatus1Count, String description, List<PlanEntry> entries, int failedCount, PlanId id,
                boolean isCompleted, MilestoneId milestoneId, String name, int passedCount, ProjectId projectId,
                int retestCount, int untestedCount, String url) {
        this.assignedtoId = assignedToId;
        this.blockedCount = blockedCount;
        this.completedOn = completedOn;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.customStatus1Count = customStatus1Count;
        this.description = description;
        this.entries = copy(entries);
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

    public UserId getAssignedToId() {
        return assignedtoId;
    }

    public int getBlockedCount() {
        return blockedCount;
    }

    public Timestamp getCompletedOn() {
        return completedOn;
    }

    public UserId getCreatedBy() {
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
        return copy(entries);
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

    public MilestoneId getMilestoneId() {
        return milestoneId;
    }

    public String getName() {
        return name;
    }

    public int getPassedCount() {
        return passedCount;
    }

    public ProjectId getProjectId() {
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
        //noinspection SpellCheckingInspection
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
        private final PlanEntryId id;
        private final String name;
        private final SuiteId suiteId;
        private final List<Run> runs;
        private final List<ConfigurationId> configIds;
        private final boolean includeAll;
        @SuppressWarnings("SpellCheckingInspection")
        private final UserId assignedtoId;

        @SuppressWarnings("BooleanParameter")
        public PlanEntry(PlanEntryId id, String name, SuiteId suiteId, List<Run> runs, List<ConfigurationId>
                configIds, boolean includeAll, UserId assignedToId) {
            this.id = id;
            this.name = name;
            this.suiteId = suiteId;
            this.runs = copy(runs);
            this.configIds = copy(configIds);
            this.includeAll = includeAll;
            this.assignedtoId = assignedToId;
        }

        public PlanEntryId getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public SuiteId getSuiteId() {
            return suiteId;
        }

        public List<Run> getRuns() {
            return copy(runs);
        }

        public List<ConfigurationId> getConfigIds() {
            return copy(configIds);
        }

        public boolean isIncludeAll() {
            return includeAll;
        }

        public UserId getAssignedToId() {
            return assignedtoId;
        }

        @Override
        public String toString() {
            //noinspection SpellCheckingInspection
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

    public static class PlanEntryId extends Id {
        public PlanEntryId(String id) {
            super(id);
        }
    }
}
