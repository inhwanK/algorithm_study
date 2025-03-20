package algorithm_study.programers.level2;

public class Pro389479 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        // 증감 배열
        int[] server = new int[players.length];
        int[] incArr = new int[players.length];
        // 증감 공식세우기
        for (int i = 0; i < players.length; i++) {
            // 각 시간마다 필요한 증설 서버 체크
            // 현재 증설 서버보다 적게 필요할 경우 아무것도 안함.
            if (players[i] / m <= server[i]) {
                continue;
            }

            // 현재 증설서버보다 많이 필요할 경우 차이 구하기
            incArr[i] = (players[i] / m) - server[i];
            for (int j = 0; j < k; j++) {
                if (i + j >= server.length) {
                    break;
                }
                server[i + j] += incArr[i];
            }
        }

        for (int i = 0; i < incArr.length; i++) {
            answer += incArr[i];
        }

        return answer;
    }
}
