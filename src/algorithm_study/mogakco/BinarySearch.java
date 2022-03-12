package algorithm_study.mogakco;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {215, 513, 712, 803};
        int key = 10;

//        int cableLength = binarySearch(arr, key);

        int min = 0;
        int max = arr[arr.length - 1];

        int value;
        int cableLength = 0;

        // while 문 시작
        while (min < max) {
            int mid = min + (max - min) / 2;

            value = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                value += arr[i] / mid;
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

        System.out.println("정답 > " + cableLength);
    }

    // 현재 안쓰는 메서드임.
    public static int binarySearch(int[] arr, int key) {
        return -1;
    }
}



