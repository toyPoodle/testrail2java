package de.vik.testrail2java.types;

import java.util.List;

import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.Plan.TestRunId;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Status.StatusId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.custom.Step;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.TimeSpan;

public class Test {
	@SuppressWarnings("SpellCheckingInspection")
	private UserId assignedtoId;
	private CaseId caseId;
	private String customExpected;
	@SuppressWarnings("SpellCheckingInspection")
	private String customPreconds;
	private List<Step> customStepsSeparated;
	private TimeSpan estimate;
	private TimeSpan estimateForecast;
	private TestId id;
	private PriorityId priorityId;
	private TestRunId runId;
	private StatusId statusId;
	private String title;
	private TypeId typeId;

	private Test(UserId assignedToId, CaseId caseId, String expected, String preconditions, List<Step> steps, TimeSpan estimate,
				 TimeSpan estimateForecast, TestId id, PriorityId priorityId, TestRunId runId, StatusId statusId, String title, TypeId typeId) {
		this.assignedtoId = assignedToId;
		this.caseId = caseId;
		this.customExpected = expected;
		this.customPreconds = preconditions;
		this.customStepsSeparated = steps;
		this.estimate = estimate;
		this.estimateForecast = estimateForecast;
		this.id = id;
		this.priorityId = priorityId;
		this.runId = runId;
		this.statusId = statusId;
		this.title = title;
		this.typeId = typeId;
	}

	public UserId getAssignedToId() {
		return assignedtoId;
	}

	public CaseId getCaseId() {
		return caseId;
	}

	public String getExpected() {
		return customExpected;
	}

	public String getPreconditions() {
		return customPreconds;
	}

	public List<Step> getSteps() {
		return customStepsSeparated;
	}

	public TimeSpan getEstimate() {
		return estimate;
	}

	public TimeSpan getEstimateForecast() {
		return estimateForecast;
	}

	public TestId getId() {
		return id;
	}

	public PriorityId getPriorityId() {
		return priorityId;
	}

	public TestRunId getRunId() {
		return runId;
	}

	public StatusId getStatusId() {
		return statusId;
	}

	public String getTitle() {
		return title;
	}

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
