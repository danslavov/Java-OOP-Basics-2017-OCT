package Exercises.P01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public String getSurfaceArea() {
        double value = 2.0 * (length * width + length * height + width * height);
        return String.format("Surface Area - %.2f", value);
    }

    public String getLateralSurfaceArea() {
        double value = 2.0 * (length * height + width * height);
        return String.format("Lateral Surface Area - %.2f", value);
    }

    public String getVolume() {
        double value = length * width * height;
        return String.format("Volume - %.2f", value);
    }
}
