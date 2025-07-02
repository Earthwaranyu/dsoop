//Waranyu Chunhachatcharachai 6681376

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Lecture15 {
    public static <T> void insertionSort(T[] array, Comparator<T> cc){
        for(int i = 1; i < array.length ; i++){
            T key = array[i];
            int j = i - 1;
            while(j >= 0 && cc.compare(array[j], key) > 0){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    public static <T> void quickSort(T[] array, Comparator<T> cc){
        quickSortHelper(array, 0, array.length - 1, cc);
    }

    public static <T> void quickSortHelper(T[] array, int low, int high, Comparator<T> cc){
        if(low < high){
            int pivotIndex = randomizedPartition(array, low, high, cc);
            quickSortHelper(array, low, pivotIndex - 1, cc);
            quickSortHelper(array, pivotIndex + 1, high, cc);
        }
    }

    public static <T> int randomizedPartition(T[] array, int low, int high, Comparator<T> cc){
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1);
        swap(array, pivotIndex, high);
        return partition(array, low, high, cc);

    }

    public static <T> int partition(T[] array, int low, int high, Comparator<T> cc){
        T pivot = array[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(cc.compare(array[j], pivot) <= 0){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }

    public static <T> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void mergeSort(T[] array, Comparator<T> cc){
        if(array.length <= 1) return;

        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left, cc);
        mergeSort(right, cc);

        mergeSortHelper(array, left, right, cc);
    }
    public static <T> void mergeSortHelper(T[] result, T[] left, T[] right, Comparator<T> cc){
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if(cc.compare(left[i], right[j]) <= 0){
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }

        while(i < left.length){
            result[k++] = left[i++];
        }

        while(j < right.length){
            result[k++] = right[j++];
        }
    }


    public static <T> void printArray(T[] array){
        for(T item : array){
            System.out.println(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Integer[] array = {3,2,1};

        Comparator<Integer> cc = Integer::compare;
        printArray(array);

        insertionSort(array, cc);
        printArray(array);


        Integer[] array2 = {3,2,1};


        printArray(array2);

        quickSort(array2, cc);

        printArray(array2);


        Integer[] array3 = {3,2,1};


        printArray(array3);

        mergeSort(array3, cc);

        printArray(array3);
    }
}
