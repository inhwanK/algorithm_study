package algorithm_study.programers.level3;

import java.util.*;
import java.util.regex.*;

// 불량 사용자 - https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class Pro64064 {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        boolean[] visited = new boolean[user_id.length];

        HashSet<String> set = new HashSet();

        dfs(0, user_id, banned_id, visited, "", set);

        return set.size();
    }


    private void dfs(int depth, String[] user_id, String[] banned_id, boolean[] visited, String target, HashSet<String> set) {
        if (depth == banned_id.length) {
            char[] newTarget = target.toCharArray();
            Arrays.sort(newTarget);
            String result = "";
            for (int i = 0; i < newTarget.length; i++) {
                result += newTarget[i];
            }
            set.add(result);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && match(banned_id[depth], user_id[i])) {
                visited[i] = true;
                dfs(depth + 1, user_id, banned_id, visited, target + "" + i, set);
                visited[i] = false;
            }
        }

    }

    // 제재 id 확인
    private boolean match(String banned, String user) {
        if (banned.length() != user.length()) {
            return false;
        }

        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) == '*') {
                continue;
            }

            if (banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

class Pro64064Answer1 {

    Set<Integer> set;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        go(0, user_id, banned_id, 0);

        return set.size();
    }

    public void go(int index, String[] user_id, String[] banned_id, int bit) {

        if (index == banned_id.length) {
            set.add(bit);
            return;
        }

        String reg = banned_id[index].replace("*", "[\\w\\d]");
        for (int i = 0; i < user_id.length; ++i) {
            if ((((bit >> i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            go(index + 1, user_id, banned_id, (bit | 1 << i));
        }

    }
}

class Pro64064Answer2 {
    static boolean[] visit;
    static ArrayList<String> list = new ArrayList<>();
    static HashSet<String> set;
    static ArrayList<HashSet> result = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        Arrays.sort(banned_id);
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        visit = new boolean[user_id.length];
        dfs(banned_id, user_id, 0);

        int answer = result.size();
        return answer;
    }

    static void dfs(String[] banned_id, String[] user_id, int idx) {
        if (idx == banned_id.length) {
            set = new HashSet<>();
            set.addAll(list);

            boolean flag = true;
            // 같은 아이디로 이루어진 조합있는지 체크
            for (HashSet str : result) {
                if (str.containsAll(list)) flag = false;
            }
            if (flag) result.add(set); // 없는 경우

            return;
        }
        Pattern idPattern = Pattern.compile(banned_id[idx]);
        for (int i = 0; i < user_id.length; i++) {
            Matcher matcher = idPattern.matcher(user_id[i]);

            //정규식 표현에 맞는 문자
            if (matcher.matches() && !visit[i]) {
                list.add(user_id[i]);
                visit[i] = true;
                dfs(banned_id, user_id, idx + 1);
                visit[i] = false;
                list.remove(idx);
            }
        }
    }
}