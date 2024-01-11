import java.util.Arrays;

public class Part1 {

    public static void main(String args[]) {
        int n = 10000;
        int k = 5;
        // Each element of the array is between 0 and 4n
        int[] arr = generateRandomArray(n);

        // Sorting is pre-condition of the search algorithms in this lab
        Arrays.sort(arr);

        // Insert appropriate code segments to calculate execution time
        long startTime = System.currentTimeMillis();
        long endTime = 0;

        // Checking if the method can correctly find already existing elements
        for (int elem : arr) {
            int res = genericSearch(arr, elem, 0, arr.length - 1, k);
            //int res = 3;
            endTime = System.currentTimeMillis();
            // call the search function and assign it to ``res``
            // Generalize the code so that you can experiment with different k values in a single execution
            if (elem != arr[res]) {
                throw new ExceptionDemo("Method works incorrectly (cannot properly locate elements)");
            }
        }


        // Checking if the method can correctly report absence of elements
        int[] nonExistingElements = {-90, -54, 5 * n + 5, 6 * n};
        for(int elem: nonExistingElements){
            int res = genericSearch(arr, elem, 0, arr.length - 1, k);
            // call the search function and assign it to ``res``
            // Generalize the code so that you can experiment with different k values in a single execution
            if (res != -1) {
                throw new ExceptionDemo("Method works incorrectly (cannot report absence of elements)");
            }
        }

        System.out.println("TIME ELAPSED: " + (endTime - startTime));
        /*
        int[] demo = {54,23,65,764,43,2343,532,54,21,34,12,19};

        for(int elem: demo) {
            System.out.print(elem + " - ");
        }
        System.out.println();

        Arrays.sort(demo);
        for(int elem: demo) {
            System.out.print(elem + " - ");
        }
        System.out.println();

        System.out.println(genericSearch(demo, 12, 0 , demo.length - 1, 4));
         */


    }

    public static int binarySearch(int[] arr, int target, int low, int high){
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            if (target < arr[mid])
                return binarySearch(arr, target,low, mid - 1);

            return binarySearch(arr, target,mid + 1, high);
        }
        return -1;
    }

    public static int ternarySearch(int[] arr, int target, int low, int high){
        if (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = low + 2 * (high - low) / 3;

            if (arr[mid1] == target)
                return arr[mid1];

            if (arr[mid2] == target)
                return arr[mid2];

            if (target < arr[mid1])
                return binarySearch(arr, target,low, mid1);

            if (target < arr[mid2])
                return binarySearch(arr, target, mid1 + 1, mid2);

            return binarySearch(arr, target, mid2 + 1, high);
        }
        return -1;
    }

    public static int genericSearch(int[] arr, int target, int low, int high, int k){
        if (low > high)
            return -1;

        int[] mids = new int[k - 1];
        for(int i = 0; i < k - 1; i++) {
            mids[i] = low + (i + 1) * (high - low) / k;
            //System.out.println("Mid--" + i + "----" + mids[i]);
        }

        for(int i = 0; i < k - 1; i++) {
            if (arr[mids[i]] == target) {
                //System.out.println("MID FOUND--" + i);
                return mids[i];
            }
        }

        int i = 0;
        while(i < k - 1) {
            if(target < arr[mids[i]]) {
                //System.out.println("Inner--" + i);
                if(i == 0) {
                    return genericSearch(arr, target, low, mids[i] - 1, k);
                }
                return genericSearch(arr, target, mids[i - 1] + 1, mids[i] - 1 , k);
            }
            else {
                //System.out.println("Inner2--" + i);
                i++;
            }

            if(i == k - 1) {
                return genericSearch(arr, target, mids[i - 1] + 1, high , k);
            }

        }
        return -1;
    }


    /**
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     */

    public static int[] generateRandomArray(int length)
    {
        int[] array = new int[length];

        for (int i = 0; i < length; ++i)
        {
            array[i] = (int)(Math.random() * length * 4);
        }

        return array;
    }

}
