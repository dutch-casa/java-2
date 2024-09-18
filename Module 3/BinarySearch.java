import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if(a == null || key == null || comparator == null) throw new NullPointerException();
        int left = 0;
        int right = a.length - 1;
        if(comparator.compare(a[0], key) == 0) return 0;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(comparator.compare(key, a[middle]) < 0) right = middle - 1;
            else if(comparator.compare(key, a[middle]) > 0) left = middle + 1;
            else if(comparator.compare(a[middle - 1], a[middle]) == 0) right = middle - 1;
            else return middle;
        }
        return -1;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if(a == null || key == null || comparator == null) throw new NullPointerException();
        int left = 0;
        int right = a.length - 1;
        if(comparator.compare(a[right], key) == 0) return right;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(comparator.compare(key, a[middle]) < 0) right = middle - 1;
            else if(comparator.compare(key, a[middle]) > 0) left = middle + 1;
            else if(comparator.compare(a[middle - 1], a[middle]) == 0) left = middle + 1;
            else return middle;
        }
        return -1;
    }

}
