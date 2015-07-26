package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Status.StatusId;
import de.vik.testrail2java.types.Test.TestId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.custom.StepResult;
import de.vik.testrail2java.types.primitive.NumericId;
import de.vik.testrail2java.types.primitive.TimeSpan;
import de.vik.testrail2java.types.primitive.Timestamp;

/**
 * http://docs.gurock.com/testrail-api2/reference-results
 */
public class Result {
	@SuppressWarnings("SpellCheckingInspection")
    private UserId assignedtoId;
	private String comment;
	private UserId createdBy;
	private Timestamp createdOn;
	private List<StepResult> customStepResults;
	private String defects;
	private TimeSpan elapsed;
	private ResultId id;
	private StatusId statusId;
	private TestId testId;
	private String version;

    /**
     * For tests
     */
	Result(UserId assignedToId, String comment, UserId createdBy, Timestamp createdOn, List<StepResult> stepResults, String defects,
				  TimeSpan elapsed, ResultId id, StatusId statusId, TestId testId, String version) {
		this.assignedtoId = assignedToId;
		this.comment = comment;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.customStepResults = new ArrayList<>(stepResults);
		this.defects = defects;
		this.elapsed = elapsed;
		this.id = id;
		this.statusId = statusId;
		this.testId = testId;
		this.version = version;
	}

	public Result(StatusId statusId, String comment, String version, TimeSpan elapsed, String defects, UserId assignedToId,
				  List<StepResult> stepResults, TestId testId) {
		this.statusId = statusId;
		this.comment = comment;
		this.version = version;
		this.elapsed = elapsed;
		this.defects = defects;
		this.assignedtoId = assignedToId;
		this.customStepResults = new ArrayList<>(stepResults);
		this.testId = testId;
	}

	/**
	 * The ID of the assignee (user) of the test result
	 */
	public UserId getAssignedToId() {
		return assignedtoId;
	}

	/**
	 * The comment or error message of the test result
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * The ID of the user who created the test result
	 */
	public UserId getCreatedBy() {
		return createdBy;
	}

	/**
	 * The date/time when the test result was created (as UNIX timestamp)
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public List<StepResult> getStepResults() {
		return new ArrayList<>(customStepResults);
	}

	/**
	 * A comma-separated list of defects linked to the test result
	 */
	public String getDefects() {
		return defects;
	}

	/**
	 * The amount of time it took to execute the test (e.g. "1m" or "2m 30s")
	 */
	public TimeSpan getElapsed() {
		return elapsed;
	}

	/**
	 * The unique ID of the test result
	 */
	public ResultId getId() {
		return id;
	}

	/**
	 * The status of the test result, e.g. passed or failed
	 */
	public StatusId getStatusId() {
		return statusId;
	}

	/**
	 * The ID of the test this test result belongs to
	 */
	public TestId getTestId() {
		return testId;
	}

	/**
	 * The (build) version the test was executed against
	 */
	public String getVersion() {
		return version;
	}

    @Override
	@SuppressWarnings("SpellCheckingInspection")
	public String toString() {
		return "Result{" +
				"assignedtoId=" + assignedtoId +
				", comment='" + comment + '\'' +
				", createdBy=" + createdBy +
				", createdOn=" + createdOn +
				", customStepResults=" + customStepResults +
				", defects='" + defects + '\'' +
				", elapsed=" + elapsed +
				", id=" + id +
				", statusId=" + statusId +
				", testId=" + testId +
				", version='" + version + '\'' +
				'}';
	}

	public static class ResultId extends NumericId {
		public ResultId(int id) {
			super(id);
		}
	}

}
