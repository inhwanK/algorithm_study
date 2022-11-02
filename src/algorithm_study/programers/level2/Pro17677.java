package algorithm_study.programers.level2;

import java.util.*;

// 뉴스 클러스터링 - https://school.programmers.co.kr/learn/courses/30/lessons/17677
public class Pro17677 {
    Map<String, Integer> str1Map;
    Map<String, Integer> str2Map;
    Set<String> set;

    public int solution(String str1, String str2) {
        int answer = 0;
        int mod = 65536;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        str1Map = new HashMap();
        str2Map = new HashMap();
        set = new HashSet();

        createSubsetMap(str1, str2);

        float inter = 0;
        float union = 0;

        for (String str : set) {
            inter += Math.min(str1Map.getOrDefault(str, 0), str2Map.getOrDefault(str, 0));
            union += Math.max(str1Map.getOrDefault(str, 0), str2Map.getOrDefault(str, 0));
        }

        if (union <= inter) {
            return mod;
        }

        answer = (int) Math.floor(inter / union * mod);
        return answer;
    }

    private void createSubsetMap(String str1, String str2) {

        for (int i = 0; i < str1.length() - 1; i++) {
            String subset = str1.substring(i, i + 2);
            if (isAlph(subset)) {
                str1Map.put(subset, str1Map.getOrDefault(subset, 0) + 1);
                set.add(subset);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String subset = str2.substring(i, i + 2);
            if (isAlph(subset)) {
                str2Map.put(subset, str2Map.getOrDefault(subset, 0) + 1);
                set.add(subset);
            }
        }
    }

    private boolean isAlph(String subset) {
        char left = subset.charAt(0);
        char right = subset.charAt(1);

        if (!Character.isLowerCase(left) || !Character.isLowerCase(right)) {
            return false;
        }
        return true;
    }
}
