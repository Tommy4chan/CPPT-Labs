/**
 * Class <code>Cylinder</code> implements Object
 */
public class Cylinder implements Object {
    private String color;
    private double radius;
    private double height;

    /**
     * Constructor
     * 
     * @param color  Color
     * @param radius Radius
     * @param height Height
     */
    public Cylinder(String color, double radius, double height) {
        this.color = color;
        this.radius = radius;
        this.height = height;
    }

    /**
     * Method set color of object
     * 
     * @param color Color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return String with color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Method return object volume
     * 
     * @return Double
     */
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    /**
     * Method set cylinder radius
     * 
     * @param radius Radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Method return radius
     * 
     * @return Double
     */

    public double getRadius() {
        return radius;
    }

    /**
     * Method set cylinder height
     * 
     * @param height Height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Method return height
     * 
     * @return Double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Method compare objects
     * 
     * @param obj Object
     * @return int (0, 1, -1)
     */
    public int compareTo(Object obj) {
        Double v = getVolume();
        return v.compareTo(obj.getVolume());
    }

    /**
     * Method print object data
     */
    public void printData() {
        System.out.print("Object: Cylinder, Color: " + color + ", Volume: " + getVolume() + ";\n");
    }
}
