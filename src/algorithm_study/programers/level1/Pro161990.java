package algorithm_study.programers.level1;

// 바탕화면 정리 - https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Pro161990 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int xMin = 50;
        int yMin = 50;
        int xMax = 0;
        int yMax = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            String target = wallpaper[i];
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) == '#') {
                    xMin = Math.min(xMin, i);
                    yMin = Math.min(yMin, j);
                    xMax = Math.max(xMax, i);
                    yMax = Math.max(yMax, j);
                }
            }
        }
//        answer[0] = xMin;
//        answer[1] = yMin;
//        answer[2] = xMax + 1;
//        answer[3] = yMax + 1;

//        return answer;
        return new int[]{xMin, xMin, xMax + 1, yMax + 1};
    }
}
