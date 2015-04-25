package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.primitive.NumericId;

public class CaseField {
    private List<Config> configs;
    private String description;
    private int displayOrder;
    private CaseFieldId id;
    private String label;
    private String name;
    private String systemName;
    private Type.TypeId typeId;

    public CaseField(List<Config> configs, String description, int displayOrder, CaseFieldId id, String label, String name, String systemName, Type.TypeId typeId) {
        this.configs = configs;
        this.description = description;
        this.displayOrder = displayOrder;
        this.id = id;
        this.label = label;
        this.name = name;
        this.systemName = systemName;
        this.typeId = typeId;
    }

    public List<Config> getConfigs() {
        return new ArrayList<Config>(configs);
    }

    public String getDescription() {
        return description;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public CaseFieldId getId() {
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

    public Type.TypeId getTypeId() {
        return typeId;
    }

    public static class Config {
        private Context context;
        private ConfigId id;
        private Options options;

        public Config(Context context, ConfigId id, Options options) {
            this.context = context;
            this.id = id;
            this.options = options;
        }

        public Context getContext() {
            return context;
        }

        public ConfigId getId() {
            return id;
        }

        public Options getOptions() {
            return options;
        }

        @Override
        public String toString() {
            return "Config{" +
                    "context=" + context +
                    ", id=" + id +
                    ", options=" + options +
                    '}';
        }
    }

    private static class Options {
        private String defaultValue;
        private String format;
        private boolean isRequired;
        private String rows;

        public Options(String defaultValue, String format, boolean isRequired, String rows) {
            this.defaultValue = defaultValue;
            this.format = format;
            this.isRequired = isRequired;
            this.rows = rows;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public String getFormat() {
            return format;
        }

        public boolean isRequired() {
            return isRequired;
        }

        public String getRows() {
            return rows;
        }

        @Override
        public String toString() {
            return "Options{" +
                    "defaultValue='" + defaultValue + '\'' +
                    ", format='" + format + '\'' +
                    ", isRequired=" + isRequired +
                    ", rows='" + rows + '\'' +
                    '}';
        }
    }

    public static class Context {
        private boolean isGlobal;
        private int projectIds;

        public Context(boolean isGlobal, int projectIds) {
            this.isGlobal = isGlobal;
            this.projectIds = projectIds;
        }

        public boolean isGlobal() {
            return isGlobal;
        }

        public int getProjectIds() {
            return projectIds;
        }

        @Override
        public String toString() {
            return "Context{" +
                    "isGlobal=" + isGlobal +
                    ", projectIds=" + projectIds +
                    '}';
        }
    }

    public static class CaseFieldId extends NumericId {
        public CaseFieldId(int id) {
            super(id);
        }
    }

    public static class ConfigId extends NumericId {
        public ConfigId(int id) {
            super(id);
        }
    }

    @Override
    public String toString() {
        return "CaseField{" +
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
}
