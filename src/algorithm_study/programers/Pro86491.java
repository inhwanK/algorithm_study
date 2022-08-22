package algorithm_study.programers;


// 최소직사각형 - https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Pro86491 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }

        answer = maxW * maxH;
        return answer;
    }
}

class Pro86491Answer {
    public int solution(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
}
