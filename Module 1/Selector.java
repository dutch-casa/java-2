import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Dutch Casadaban (hhc0006@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  08/29/2023
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        if (a == null || a.length == (0)) {
            throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        int compare = a[0];
        for (int num: a) {
            if (num < compare) {
                compare = num;   
            }
        }
        return compare;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        if ( a == null || a.length == (0)) {
             throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        int compare = a[0];
        for (int num: a) {
            if (num > compare) {
                compare = num;   
            }
        }
        return compare;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
       if ( a == null || a.length == (0) || k > a.length) {
             throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        int[] returnArray = Arrays.copyOf(a, a.length);
        Arrays.sort(returnArray);
        System.out.print(Arrays.toString(returnArray));
        return returnArray[k - 1];
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {
        if ( a == null || a.length == (0) || k > a.length) {
             throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        int[] returnArray = Arrays.copyOf(a, a.length);
        Arrays.sort(returnArray);
        return returnArray[returnArray.length - k];
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
        int[] returnArray = new int[0];
        if ( a == null || a.length == (0)) {
             throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        for (int num : a) {
            if (num >= low && num <= high) {
               returnArray = Arrays.copyOf(returnArray, returnArray.length + 1);
               returnArray[returnArray.length - 1] = num;
            }
        }
        return returnArray;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
        if ( a == null || a.length == (0)) {
             throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        
        int compare = Integer.MAX_VALUE;
        
        for (int num : a) {
            if (num >= key && num < compare) {
               compare = num;
            }
        }
        
        if (compare == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Error! No qualifying values found.");
        }
        return compare;
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        if ( a == null || a.length == (0)) {
             throw new IllegalArgumentException("Error! Illegal argument input!");   
        }
        
        int compare = Integer.MIN_VALUE;
        
        for (int num : a) {
            if (num <= key && num > compare) {
               compare = num;
            }
        }
        
        if (compare == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Error! No qualifying values found.");
        }
        return compare;
    }

}
