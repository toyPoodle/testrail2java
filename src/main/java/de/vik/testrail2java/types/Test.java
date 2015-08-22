package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.controller.Statuses;
import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Run.RunId;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Status.StatusId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.custom.Step;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.TimeSpan;

public class Test {
	@SuppressWarnings("SpellCheckingInspection")
	private final UserId assignedtoId;
	private final CaseId caseId;
	private final String customExpected;
	@SuppressWarnings("SpellCheckingInspection")
	private final String customPreconds;
	private final List<Step> customStepsSeparated;
	private final TimeSpan estimate;
	private final TimeSpan estimateForecast;
	private final TestId id;
	private final MilestoneId milestoneId;
    private final String refs;
	private final PriorityId priorityId;
	private final RunId runId;
	private final StatusId statusId;
	private final String title;
	private final TypeId typeId;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
	Test(UserId assignedToId, CaseId caseId, String expected, String preconditions, List<Step> steps, TimeSpan estimate,
                 TimeSpan estimateForecast, TestId id, MilestoneId milestoneId, String refs, PriorityId priorityId, RunId runId, StatusId statusId, String title, TypeId typeId) {
		this.assignedtoId = assignedToId;
		this.caseId = caseId;
		this.customExpected = expected;
		this.customPreconds = preconditions;
        this.customStepsSeparated = new ArrayList<>(steps);
		this.estimate = estimate;
		this.estimateForecast = estimateForecast;
		this.id = id;
        this.milestoneId = milestoneId;
        this.refs = refs;
		this.priorityId = priorityId;
		this.runId = runId;
		this.statusId = statusId;
		this.title = title;
		this.typeId = typeId;
	}

	/**
	 * The ID of the user the test is assigned to
	 */
	public UserId getAssignedToId() {
		return assignedtoId;
	}

	/**
	 * The ID of the user the test is assigned to
	 */
	public CaseId getCaseId() {
		return caseId;
	}

    /**
     * Custom expected field of the related test case
     */
	public String getExpected() {
		return customExpected;
	}

    /**
     * Custom preconditions field of the related test case
     */
	public String getPreconditions() {
		return customPreconds;
	}

    /**
     * Custom test steps from the related test case
     */
	public List<Step> getSteps() {
		return new ArrayList<>(customStepsSeparated);
	}

	/**
	 * The estimate of the related test case, e.g. "30s" or "1m 45s"
	 */
	public TimeSpan getEstimate() {
		return estimate;
	}

	/**
	 * The estimate forecast of the related test case, e.g. "30s" or "1m 45s"
	 */
	public TimeSpan getEstimateForecast() {
		return estimateForecast;
	}

	/**
	 * The unique ID of the test
	 */
	public TestId getId() {
		return id;
	}

    /**
     * The ID of the milestone that is linked to the test case
     */
    public MilestoneId getMilestoneId() {
        return milestoneId;
    }

    /**
     * A comma-separated list of references/requirements that are linked to the test case
     */
    public String getRefs() {
        return refs;
    }

    /**
     * The ID of the priority that is linked to the test case
     */
    public PriorityId getPriorityId() {
		return priorityId;
	}

    /**
     * The ID of the test run the test belongs to
     */
	public RunId getRunId() {
		return runId;
	}

    /**
     * The ID of the current status of the test, also see {@link Statuses#getStatuses()}
     */
	public StatusId getStatusId() {
		return statusId;
	}

    /**
     * The title of the related test case
     */
	public String getTitle() {
		return title;
	}

    /**
     * The ID of the test case type that is linked to the test case
     */
	public TypeId getTypeId() {
		return typeId;
	}

    @Override
    @SuppressWarnings("SpellCheckingInspection")
    public String toString() {
        return "Test{" +
                "assignedtoId=" + assignedtoId +
                ", caseId=" + caseId +
                ", customExpected='" + customExpected + '\'' +
                ", customPreconds='" + customPreconds + '\'' +
                ", customStepsSeparated=" + customStepsSeparated +
                ", estimate=" + estimate +
                ", estimateForecast=" + estimateForecast +
                ", id=" + id +
                ", milestoneId=" + milestoneId +
                ", refs='" + refs + '\'' +
                ", priorityId=" + priorityId +
                ", runId=" + runId +
                ", statusId=" + statusId +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    public static class TestId extends NumericId {
		public TestId(int id) {
			super(id);
		}
	}
}
