package algorithm_study.mogakco.sort;

public class QuickSortEx {
    public static void main(String[] args) {

        int[] arr = {5, 3, 7, 6, 2, 1, 4};

        quickSort(arr, 0, 6);

        printArr(arr);

    }

    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot = arr[end];
        int left = start;

        for (int right = start; right < end; right++) {
            if (arr[right] < pivot) {
                // swap
                swap(arr, left, right);

                left++;
            }
        }

        // swap
        swap(arr, left, end);

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    public static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

}