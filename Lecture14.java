//Waranyu Chunhachatcharachai 6681376

import java.util.Arrays;

public class Lecture14 {
    public static int linearSearch(String[] array, String tarketKey){
        for(int i = 0; i < array.length; i++){
            if(tarketKey.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(String[] array, String tarketKey){
        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int cmp = tarketKey.compareTo(array[mid]);

            if (cmp == 0) return mid;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return - 1;
    }

    public static void main(String[] args){
        String[] unsorted = {"ab", "cc", "bex", "def"};
        String[] sorted = {"ab",  "bex", "cc", "def"};

        System.out.println(linearSearch(unsorted, "cc"));
        System.out.println(linearSearch(unsorted, "cd"));
        System.out.println(linearSearch(sorted, "cd"));
        System.out.println(linearSearch(sorted, "cc"));
    }


    int primSum(int[] xs) {
        if (xs.length == 1) return xs[0];   // O(1)
        if (xs.length == 2) return xs[0] + xs[1];    // O(1)
        else {
            int[] ys = Arrays.copyOfRange(xs, 1, xs.length);    // O(n)
            return xs[0]+xs[1]+primSum(ys);   // T(n-1)
        }
        //T(n) = T(n-1) + O(n) = O(n^2)
    }

    int whazIt(int[] ys) {
        if (ys.length == 0) return 0;    // O(1)
        if (ys.length == 1) return ys[0];   // O(1)
        int n = ys.length;   // O(1)
        int m = n/2;   // O(1)
        for (int i=0;i<n;i++) {    // O(n)
            int theSum = 0;
            for (int j=0;j<=i;j++) { theSum += ys[j]; }   // O(n)
            ys[i] = theSum;
        }
        int a = whazIt(Arrays.copyOfRange(ys, 0, m));   //T(n/2)
        int b = whazIt(Arrays.copyOfRange(ys, m, ys.length));   //T(n/2)
        return a + b;   //O(1)
    }
    //T(n) = 2T(n/2) + O(n) * O(n) = O(n^2)
}
