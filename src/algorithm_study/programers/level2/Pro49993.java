package algorithm_study.programers.level2;

import java.util.*;

// 스킬트리 - https://school.programmers.co.kr/learn/courses/30/lessons/49993
public class Pro49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        char[] sk = skill.toCharArray();
        ArrayList<Character> list = new ArrayList();
        for (int i = 0; i < sk.length; i++) {
            list.add(sk[i]);
        }

        for (String target : skill_trees) {
            int index = 0;
            for (int i = 0; i < target.length(); i++) {
                if (!list.contains(target.charAt(i))) {
                    continue;
                }

                if (sk[index] != target.charAt(i)) {
                    answer--;
                    break;
                }

                if (index == skill.length() - 1) {
                    break;
                }

                index++;
            }
        }
        return answer;
    }
}

class Pro49993Answer {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
}
