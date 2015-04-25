package de.vik.testrail2java.serialization;

import de.vik.testrail2java.types.Case;
import de.vik.testrail2java.types.ConfigurationGroup;
import de.vik.testrail2java.types.Milestone;
import de.vik.testrail2java.types.Plan;
import de.vik.testrail2java.types.Suite;
import de.vik.testrail2java.types.Type;
import de.vik.testrail2java.types.primitive.Timestamp;
import de.vik.testrail2java.types.CaseField.CaseFieldId;
import de.vik.testrail2java.types.CaseField.ConfigId;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.TimeSpan;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;

public class GsonBuilder {

    private com.google.gson.GsonBuilder defaultBuilder() {
        com.google.gson.GsonBuilder gsonBuilder = new com.google.gson.GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.setPrettyPrinting();

        registerIdAdapter(gsonBuilder);

        gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampAdapter());
        gsonBuilder.registerTypeAdapter(TimeSpan.class, new TimeSpanAdapter());
        return gsonBuilder;
    }

    private void registerIdAdapter(com.google.gson.GsonBuilder gsonBuilder) {
        gsonBuilder.registerTypeAdapter(CaseFieldId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(Case.CaseId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ConfigId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ConfigurationGroup.ConfigurationGroupId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ConfigurationGroup.ConfigurationId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(Milestone.MilestoneId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(Plan.PlanEntryId.class, new PlanEntryIdAdapter());
        gsonBuilder.registerTypeAdapter(Plan.PlanId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(PriorityId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ProjectId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(SectionId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(Suite.SuiteId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(Plan.TestRunId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(Type.TypeId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(UserId.class, new NumericIdAdapter());
    }

    public Gson create() {
        return defaultBuilder().create();
    }

    public Gson createFor(String... allowedFields) {
        return defaultBuilder().addSerializationExclusionStrategy(new FieldExclusionStrategy(allowedFields)).create();
    }
}
