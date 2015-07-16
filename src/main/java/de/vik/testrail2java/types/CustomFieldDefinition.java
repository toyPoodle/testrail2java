package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.primitive.Id;
import de.vik.testrail2java.types.primitive.NumericId;

public class CustomFieldDefinition {

    private List<CustomFieldConfig> configs;
    private String description;
    private int displayOrder;
    private CustomFieldDefinitionId id;
    private String label;
    private String name;
    private String systemName;
    private TypeId typeId;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    CustomFieldDefinition(List<CustomFieldConfig> configs, String description, int displayOrder, CustomFieldDefinitionId id, String label, String name, String systemName, TypeId typeId) {
        this.configs = configs;
        this.description = description;
        this.displayOrder = displayOrder;
        this.id = id;
        this.label = label;
        this.name = name;
        this.systemName = systemName;
        this.typeId = typeId;
    }

    public List<CustomFieldConfig> getConfigs() {
        return new ArrayList<>(configs);
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
        private CustomFieldContext context;
        private CustomFieldConfigId id;
        private CustomFieldOptions options;

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
        private String format;
        private Boolean hasActual;
        private Boolean hasExpected;
        private Boolean isRequired;

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
        private Boolean isGlobal;
        private List<ProjectId> projectIds;

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
