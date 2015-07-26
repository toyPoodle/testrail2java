package de.vik.testrail2java.types;

import de.vik.testrail2java.types.primitive.NumericId;

public class Status {
    private int colorBright;
    private int colorDark;
    private int colorMedium;
    private StatusId id;
    private boolean isFinal;
    private boolean isSystem;
    private boolean isUntested;
    private String label;
    private String name;

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
