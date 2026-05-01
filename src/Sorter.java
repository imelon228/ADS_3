import java.util.Random;
public class Sorter {

    public static void BubbleSort(int[] arr){
        // BubbleSort
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void QuickSort(int[] arr){
        // QuickSort
        QuickSort(arr, 0, arr.length - 1);
    }
    private static void QuickSort(int[] arr, int start, int end){
        if(start < end){
            int pi = partition(arr, start, end);

            QuickSort(arr, start, pi -1);
            QuickSort(arr, pi + 1, end);
        }
    }
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        int i = start - 1; // index of smallest element

        for(int j = start; j<end; j++){
            if(arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1; // index of pivot
    }
    public static void printArray(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int[] generateRandomArray(int size){
        return new Random().ints(size, 1, 101).toArray();
    }
}
