package algorithm_study.mogakco.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {215, 513, 712, 803};
        int key = 10;

        int cableLength = binarySearch(arr, key);

        System.out.println("정답 > " + cableLength);
    }

    public static int binarySearch(int[] arr, int key) {

        int min = 0;
        int max = arr[arr.length - 1];

        int cableLength = 0;

        // while 문 시작
        while (min < max) {
            int mid = min + (max - min) / 2;

            int value = 0;
            System.out.println("value 초기화 > " + value);

            for (int i = 0; i < arr.length; i++) {
                value += arr[i] / mid;
                System.out.println("value > " + value);
            }

            if (value == key) {
                cableLength = mid;
                break;
            } else if (value < key) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }// while문 끝

        return cableLength;
    }
}



