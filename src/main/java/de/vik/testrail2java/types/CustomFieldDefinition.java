package de.vik.testrail2java.types;

import java.util.List;

import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.NumericId;

import static de.vik.testrail2java.utilities.ListUtils.copy;

public class CustomFieldDefinition {

    private final List<CustomFieldConfig> configs;
    private final String description;
    private final int displayOrder;
    private final CustomFieldDefinitionId id;
    private final String label;
    private final String name;
    private final String systemName;
    private final TypeId typeId;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    CustomFieldDefinition(List<CustomFieldConfig> configs, String description, int displayOrder, CustomFieldDefinitionId id, String label, String name, String systemName, TypeId typeId) {
        this.configs = copy(configs);
        this.description = description;
        this.displayOrder = displayOrder;
        this.id = id;
        this.label = label;
        this.name = name;
        this.systemName = systemName;
        this.typeId = typeId;
    }

    public List<CustomFieldConfig> getConfigs() {
        return copy(configs);
    }

    public String getDescription() {
        return description;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public CustomFieldDefinitionId getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getSystemName() {
        return systemName;
    }

    public TypeId getTypeId() {
        return typeId;
    }

    @Override
    public String toString() {
        return "CustomFieldDefinition{" +
                "configs=" + configs +
                ", description='" + description + '\'' +
                ", displayOrder=" + displayOrder +
                ", id=" + id +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", systemName='" + systemName + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    public static class CustomFieldConfig {
        private final CustomFieldContext context;
        private final CustomFieldConfigId id;
        private final CustomFieldOptions options;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        CustomFieldConfig(CustomFieldContext context, CustomFieldConfigId id, CustomFieldOptions options) {
            this.context = context;
            this.id = id;
            this.options = options;
        }

        public CustomFieldContext getContext() {
            return context;
        }

        public CustomFieldConfigId getId() {
            return id;
        }

        public CustomFieldOptions getOptions() {
            return options;
        }

        @Override
        public String toString() {
            return "CustomFieldConfig{" +
                    "context=" + context +
                    ", id=" + id +
                    ", options=" + options +
                    '}';
        }
    }

    public static class CustomFieldOptions {
        private final String format;
        private final Boolean hasActual;
        private final Boolean hasExpected;
        private final Boolean isRequired;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        CustomFieldOptions(String format, Boolean hasActual, Boolean hasExpected, Boolean isRequired) {
            this.format = format;
            this.hasActual = hasActual;
            this.hasExpected = hasExpected;
            this.isRequired = isRequired;
        }

        public String getFormat() {
            return format;
        }

        public Boolean hasActual() {
            return hasActual;
        }

        public Boolean hasExpected() {
            return hasExpected;
        }

        public Boolean isRequired() {
            return isRequired;
        }

        @Override
        public String toString() {
            return "CustomFieldOptions{" +
                    "format='" + format + '\'' +
                    ", hasActual=" + hasActual +
                    ", hasExpected=" + hasExpected +
                    ", isRequired=" + isRequired +
                    '}';
        }
    }

    public static class CustomFieldContext {
        private final Boolean isGlobal;
        private final List<ProjectId> projectIds;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        CustomFieldContext(Boolean isGlobal, List<ProjectId> projectIds) {
            this.isGlobal = isGlobal;
            this.projectIds = projectIds;
        }

        public Boolean getIsGlobal() {
            return isGlobal;
        }

        public List<ProjectId> getProjectIds() {
            return projectIds;
        }

        @Override
        public String toString() {
            return "CustomFieldContext{" +
                    "isGlobal=" + isGlobal +
                    ", projectIds=" + projectIds +
                    '}';
        }
    }

    public static class CustomFieldConfigId extends Id {
        public CustomFieldConfigId(String id) {
            super(id);
        }
    }

    public static class CustomFieldDefinitionId extends NumericId {
        public CustomFieldDefinitionId(int id) {
            super(id);
        }
    }
}
