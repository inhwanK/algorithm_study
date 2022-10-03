package algorithm_study.programers.level1;

// 비밀지도 - https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class Pro17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            int cell = arr1[i] | arr2[i];

            for (int c = n - 1; c >= 0; c--) {
                arr[c] = cell % 2 == 1 ? '#' : ' ';
                cell /= 2;
            }

            answer[i] = "";
            for (int c = 0; c < n; c++) {
                answer[i] += arr[c] + "";
            }

        }
        return answer;
    }

    public String[] solution_1(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
