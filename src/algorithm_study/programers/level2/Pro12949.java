package algorithm_study.programers.level2;

// 하... 이거 은근 개빡세네
// 행렬의 곱셈 - https://school.programmers.co.kr/learn/courses/30/lessons/12949
public class Pro12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
