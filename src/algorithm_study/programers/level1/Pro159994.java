package algorithm_study.programers.level1;

// 카드 뭉치 - https://school.programmers.co.kr/learn/courses/30/lessons/159994
public class Pro159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        int oi = 0;
        int ti = 0;
        int end = 0;
        for (int i = 0; i < goal.length; i++) {
            if (oi < cards1.length && cards1[oi].equals(goal[i])) {
                oi++;
            } else if (ti < cards2.length && cards2[ti].equals(goal[i])) {
                ti++;
            } else {
                return "No";
            }
            end = i;
        }

        if (end == goal.length - 1) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String solutionAnswer(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx2 = 0;

        for(int i=0; i<goal.length; i++){
            String target = goal[i];

            if(cardIdx1 < cards1.length && target.equals(cards1[cardIdx1]))
                cardIdx1 ++;
            else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2]))
                cardIdx2++;
            else
                return "No";
        }


        return "Yes";
    }
}
