import java.util.ArrayList;

/**
 * Parameterized class <code>Shelf</code> implements shelf
 */

public class Shelf<T extends Object> {
    private ArrayList<T> arr;

    /**
     * Constructor
     */
    public Shelf() {
        arr = new ArrayList<T>();
    }

    /**
     * Method find object with the smallest volume
     */
    public T findMin() {
        if (!arr.isEmpty()) {
            T min = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i).compareTo(min) < 0)
                    min = arr.get(i);
            }
            return min;
        }
        return null;
    }

    /**
     * Method add new object to shelf
     * 
     * @param object value
     */

    public void AddObject(T object) {
        arr.add(object);
        System.out.print("Element added: ");
        object.printData();
    }

    /**
     * Method delete object from shelf
     * 
     * @param i The index of element
     */

    public void DeleteObject(int i) {
        arr.remove(i);
    }

}
