/**
 * Class <code>Equations</code> implements method for y=cos(x)/tg(2x)
 * expression
 * calculation
 * 
 * @author Anton panurin
 * @version 1.0
 */
public class Equations {

    /**
     * Method calculates the y=cos(x)/tg(2x) expression
     * 
     * @param x Angle in degrees
     * @throws CalcException
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try {
            y = (Math.cos(rad) / Math.tan(2 * rad));
            if (y == Double.NaN || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || x == 90
                    || x == -90)
                throw new ArithmeticException();
        } catch (ArithmeticException ex) {
            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if (x == 0)
                throw new CalcException("Exception reason: X = 0");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }

}
