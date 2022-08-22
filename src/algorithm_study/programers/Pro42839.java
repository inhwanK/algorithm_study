package algorithm_study.programers;

import java.util.HashSet;
import java.util.Set;

// substring 잘못알고 있었음, 기억하도록 !!
// 소수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class Pro42839 {
    static int depth = 0;
    static Set<Integer> set = new HashSet();
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            depth = i;
            dfs(0, "", numbers);
        }

        answer = set.size();
        return answer;
    }

    public void dfs(int n, String temp, String numbers) {
        if (depth == n) {
            int num = Integer.parseInt(temp);
            if (checkPrime(num)) {
                set.add(num);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                temp += numbers.charAt(i);
                visited[i] = true;
                dfs(n + 1, temp, numbers);
                visited[i] = false;
                temp = temp.substring(0, temp.length() - 1);

            }
        }
    }

    public boolean checkPrime(int target) {
        if (target < 2) return false;
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// 정답
class Pro42839Answer {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }

}