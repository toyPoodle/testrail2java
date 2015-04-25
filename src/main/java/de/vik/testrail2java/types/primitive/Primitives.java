package de.vik.testrail2java.types.primitive;

import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.Milestone;
import de.vik.testrail2java.types.Suite;
import de.vik.testrail2java.types.Type;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.User.UserId;

public class Primitives {
    public static SectionId sectionId(int value) {
        return new SectionId(value);
    }

    public static Suite.SuiteId suiteId(int value) {
        return new Suite.SuiteId(value);
    }

    public static Type.TypeId typeId(int value) {
        return new Type.TypeId(value);
    }

    public static PriorityId priorityId(int value) {
        return new PriorityId(value);
    }

    public static Milestone.MilestoneId milestoneId(int value) {
        return new Milestone.MilestoneId(value);
    }

    public static UserId userId(int value) {
        return new UserId(value);
    }

    public static ProjectId projectId(int value) {
        return new ProjectId(value);
    }

    public static Case.CaseId caseId(int value) {
        return new Case.CaseId(value);
    }

    public static Timestamp timestamp(long value) {
        return new Timestamp(value);
    }
}
