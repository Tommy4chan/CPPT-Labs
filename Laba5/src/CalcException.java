/**
* Class <code>CalcException</code> more precises ArithmeticException
* @author Anton Panurin
* @version 1.0
*/
public class CalcException extends ArithmeticException {
    public CalcException(){}

    public CalcException(String cause)
    {
        super(cause);
    }
}
