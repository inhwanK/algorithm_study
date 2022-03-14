package algorithm_study.mogakco.sort;

public class BubbleSortEx {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 6};

        for (int i = 0; i < arr.length; i++) { // 배열의 요소 개수 만큼 스캔 수행

            int temp = 0;
            // 요소 비교 후 정렬 수행
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("배열 스캔 중 > " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]);
            }

            System.out.println("배열 정렬 중 > " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]);
        } // 이중 for 문 끝
        System.out.println("배열 정렬 끝 > " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]);
    }
}
