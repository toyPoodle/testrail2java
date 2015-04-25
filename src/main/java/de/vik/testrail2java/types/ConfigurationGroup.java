package de.vik.testrail2java.types;

import java.util.ArrayList;
import java.util.List;

import de.vik.testrail2java.types.primitive.NumericId;

public class ConfigurationGroup {
    private ConfigurationGroupId id;
    private String name;
    private Project.ProjectId projectId;
    private List<Configuration> configs;

    public ConfigurationGroup(ConfigurationGroupId id, String name, Project.ProjectId projectId, List<Configuration> configs) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
        this.configs = configs;
    }

    public ConfigurationGroupId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Project.ProjectId getProjectId() {
        return projectId;
    }

    public List<Configuration> getConfigs() {
        return new ArrayList<Configuration>(configs);
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

        public Configuration(ConfigurationId id, ConfigurationGroupId groupId, String name) {
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
