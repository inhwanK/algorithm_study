package algorithm_study.programers.level2;

import java.util.Arrays;
import java.util.Comparator;

// 테이블 해시 함수 - https://school.programmers.co.kr/learn/courses/30/lessons/147354
public class Pro147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 정수 타입 컬럼
        // col, row_begin, row_end
        // 아주 칭찬해
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[col - 1] == o2[col - 1]) {
                    return o2[0] - o1[0];
                }
                return o1[col - 1] - o2[col - 1];
            }
        });

        int[] xor = new int[row_end - row_begin + 1];

        // S_i = data[i]에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int s_i = 0;
            for (int j = 0; j < data[i].length; j++) {
                s_i += data[i][j] % (i + 1);
            }
            answer ^= s_i;
        }

        return answer;
    }

    public int solution2(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(o1, o2) -> o1[col-1]!=o2[col-1] ?o1[col-1]-o2[col-1] :o2[0]-o1[0]);
        for(int i=row_begin-1;i<row_end;i++){
            int si = 0;
            for(int j=0; j<data[i].length;j++){
                si += data[i][j] % (i+1);
            }
            answer = answer^si;

        }

        return answer;
    }

    public int solution3(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o1[col - 1], o2[col - 1]);
        });
        int xor = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int[] row = data[i - 1];
            int sum = 0;
            for (int n : row) {
                sum += n % i;
            }
            xor ^= sum;
        }
        return xor;
    }
}
