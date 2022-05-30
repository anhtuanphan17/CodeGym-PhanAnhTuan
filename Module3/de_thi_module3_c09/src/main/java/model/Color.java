package model;

public class Color {
    private Integer colorId;
    private String colorName;

    public Color(Integer colorId, String colorName) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
