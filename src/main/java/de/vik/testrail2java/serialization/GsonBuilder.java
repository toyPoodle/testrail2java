package de.vik.testrail2java.serialization;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;

import de.vik.testrail2java.types.Case.CaseId;
import de.vik.testrail2java.types.CaseField.CaseFieldId;
import de.vik.testrail2java.types.CaseField.ConfigId;
import de.vik.testrail2java.types.ConfigurationGroup.ConfigurationGroupId;
import de.vik.testrail2java.types.ConfigurationGroup.ConfigurationId;
import de.vik.testrail2java.types.CustomFieldDefinition.CustomFieldConfigId;
import de.vik.testrail2java.types.CustomFieldDefinition.CustomFieldDefinitionId;
import de.vik.testrail2java.types.Milestone.MilestoneId;
import de.vik.testrail2java.types.Plan.PlanEntryId;
import de.vik.testrail2java.types.Plan.PlanId;
import de.vik.testrail2java.types.Plan.TestRunId;
import de.vik.testrail2java.types.Priority.PriorityId;
import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Result.ResultId;
import de.vik.testrail2java.types.Section.SectionId;
import de.vik.testrail2java.types.Status.StatusId;
import de.vik.testrail2java.types.Suite.SuiteId;
import de.vik.testrail2java.types.SuiteMode;
import de.vik.testrail2java.types.Test.TestId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.User.UserId;
import de.vik.testrail2java.types.primitive.TimeSpan;
import de.vik.testrail2java.types.primitive.Timestamp;

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
        gsonBuilder.registerTypeAdapter(CaseId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ConfigId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ConfigurationGroupId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ConfigurationId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(CustomFieldConfigId.class, new AlphaNumericIdAdapter());
        gsonBuilder.registerTypeAdapter(CustomFieldDefinitionId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(MilestoneId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(PlanEntryId.class, new AlphaNumericIdAdapter());
        gsonBuilder.registerTypeAdapter(PlanId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(PriorityId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ProjectId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(ResultId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(SectionId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(StatusId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(SuiteId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(SuiteMode.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(TestId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(TestRunId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(TypeId.class, new NumericIdAdapter());
        gsonBuilder.registerTypeAdapter(UserId.class, new NumericIdAdapter());
    }

    public Gson create() {
        return defaultBuilder().create();
    }

    public Gson createFor(AllowedFields allowedFields) {
        return defaultBuilder().addSerializationExclusionStrategy(new FieldExclusionStrategy(allowedFields)).create();
    }
}
