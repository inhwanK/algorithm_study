package algorithm_study.programers.level1;

import java.util.HashMap;
import java.util.Map;

public class Pro178871 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]);
            String swap = players[index - 1];

            players[index] = swap;
            map.put(swap, index);

            players[index - 1] = callings[i];
            map.put(callings[i], index - 1);
        }

        for (int i = 0; i < players.length; i++) {
            answer[i] = players[i];
        }
        return answer;
    }
}
