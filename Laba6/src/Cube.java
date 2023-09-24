/**
 * Class <code>Cube</code> implements Object
 */
public class Cube implements Object {
    private String color;
    private double a;

    /**
     * Constructor
     * 
     * @param color Color
     * @param a     Side size
     */
    public Cube(String color, double a) {
        this.color = color;
        this.a = a;
    }

    /**
     * @return String with color
     */
    public String getColor() {
        return color;
    }

    /**
     * Method set color of object
     * 
     * @param color Color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return Double object volume
     */
    public double getVolume() {
        return Math.pow(a, 3);
    }

    /**
     * Method set cube side size
     * 
     * @param a length
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Method return side size
     * 
     * @return Double a cube side size
     */
    public double getA() {
        return a;
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
        System.out.print("Object: Cube, Color: " + color + ", Volume: " + getVolume() + ";\n");
    }
}
