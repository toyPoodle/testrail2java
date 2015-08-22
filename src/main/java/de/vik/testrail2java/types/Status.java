package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class Status {
    private final int colorBright;
    private final int colorDark;
    private final int colorMedium;
    private final StatusId id;
    private final boolean isFinal;
    private final boolean isSystem;
    private final boolean isUntested;
    private final String label;
    private final String name;

    /**
     * Is not intended to be instantiated by API user, since this entity cannot be created via TestRail API.
     */
    Status(int colorBright, int colorDark, int colorMedium, StatusId id, boolean isFinal, boolean isSystem, boolean isUntested, String label, String name) {
        this.colorBright = colorBright;
        this.colorDark = colorDark;
        this.colorMedium = colorMedium;
        this.id = id;
        this.isFinal = isFinal;
        this.isSystem = isSystem;
        this.isUntested = isUntested;
        this.label = label;
        this.name = name;
    }

    public int getColorBright() {
        return colorBright;
    }

    public int getColorDark() {
        return colorDark;
    }

    public int getColorMedium() {
        return colorMedium;
    }

    public StatusId getId() {
        return id;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public boolean isUntested() {
        return isUntested;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "colorBright=" + colorBright +
                ", colorDark=" + colorDark +
                ", colorMedium=" + colorMedium +
                ", id=" + id +
                ", isFinal=" + isFinal +
                ", isSystem=" + isSystem +
                ", isUntested=" + isUntested +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

	public static class StatusId extends NumericId {
		public StatusId(int id) {
			super(id);
		}
	}
}
