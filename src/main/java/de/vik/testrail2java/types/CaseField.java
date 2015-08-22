package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Type.TypeId;
import de.vik.testrail2java.types.primitive.NumericId;

public class CaseField {
    private final List<Config> configs;
    private final String description;
    private final int displayOrder;
    private final CaseFieldId id;
    private final String label;
    private final String name;
    private final String systemName;
    private final TypeId typeId;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    CaseField(List<Config> configs, String description, int displayOrder, CaseFieldId id, String label, String name, String systemName, TypeId typeId) {
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
        return new ArrayList<>(configs);
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

    public TypeId getTypeId() {
        return typeId;
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

    public static class Config {
        private final Context context;
        private final ConfigId id;
        private final Options options;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        Config(Context context, ConfigId id, Options options) {
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

    public static class Options {
        private final String defaultValue;
        private final String format;
        private final boolean isRequired;
        private final String rows;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        Options(String defaultValue, String format, boolean isRequired, String rows) {
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
        private final boolean isGlobal;
        private final List<Integer> projectIds;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        Context(boolean isGlobal, List<Integer> projectIds) {
            this.isGlobal = isGlobal;
            this.projectIds = new ArrayList<>(projectIds);
        }

        public boolean isGlobal() {
            return isGlobal;
        }

        public List<Integer> getProjectIds() {
            return new ArrayList<>(projectIds);
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
}
