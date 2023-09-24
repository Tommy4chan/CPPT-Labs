/**
 * Class App realize example program for lab 6
 * 
 * @author Anton Panurin
 * @version 1.1
 * @since version 1.0
 */

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Shelf<? super Object> shelf = new Shelf<Object>();

        shelf.AddObject(new Cube("Red", 3));
        shelf.AddObject(new Cube("Blue", 6));
        shelf.AddObject(new Cylinder("Yellow", 6, 3));
        shelf.AddObject(new Cylinder("White", 2, 4));

        Object res = shelf.findMin();
        System.out.print("The smallest object on shelf is: \n");
        res.printData();
    }
}
