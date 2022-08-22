package algorithm_study.programers;

// 타겟 넘버 - https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class Pro43165 {
    static int count;

    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0, 0, numbers.length, target, numbers);

        return count;
    }

    public void dfs(int n, int sum, int depth, int target, int[] numbers) {
        if (depth == n) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(n + 1, sum + numbers[n], depth, target, numbers);
        dfs(n + 1, sum - numbers[n], depth, target, numbers);
    }
}

class Pro43165Answer {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}