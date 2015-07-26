package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.Project.ProjectId;
import de.vik.testrail2java.types.primitive.NumericId;

public class ConfigurationGroup {
    private ConfigurationGroupId id;
    private String name;
    private ProjectId projectId;
    private List<Configuration> configs;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    ConfigurationGroup(ConfigurationGroupId id, String name, ProjectId projectId, List<Configuration> configs) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.configs = new ArrayList<>(configs);
    }

    public ConfigurationGroupId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public List<Configuration> getConfigs() {
        return new ArrayList<>(configs);
    }

    @Override
    public String toString() {
        return "ConfigurationGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectId=" + projectId +
                ", configs=" + configs +
                '}';
    }

    public static class Configuration {
        private ConfigurationId id;
        private ConfigurationGroupId groupId;
        private String name;

        /**
         * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
         */
        Configuration(ConfigurationId id, ConfigurationGroupId groupId, String name) {
            this.id = id;
            this.groupId = groupId;
            this.name = name;
        }

        public ConfigurationId getId() {
            return id;
        }

        public ConfigurationGroupId getGroupId() {
            return groupId;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Configuration{" +
                    "id=" + id +
                    ", groupId=" + groupId +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class ConfigurationId extends NumericId {
        public ConfigurationId(int id) {
            super(id);
        }
    }

    public static class ConfigurationGroupId extends NumericId {
        public ConfigurationGroupId(int id) {
            super(id);
        }
    }
}
