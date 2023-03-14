package algorithm_study.programers.level2;

// 두 큐 합 같게 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class Pro118667 {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long val = 0;
        int[] arr = new int[queue1.length * 3];
        for (int i = 0; i < queue1.length; i++) {
            arr[i] = arr[queue1.length * 2 + i] = queue1[i];
            arr[queue1.length + i] = queue2[i];

            val += queue1[i];
            sum += queue1[i] + queue2[i];
        }

        int left = 0;
        int right = queue1.length - 1;
        int count = 0;

        while (val != sum / 2) {

            if (val < sum / 2) {
                right++;

                if (right == arr.length) {
                    return -1;
                }

                val += arr[right];
            } else {
                if (left == arr.length * 2 / 3 + 1) {
                    return -1;
                }

                val -= arr[left];
                left++;
            }
            count++;
        }

        return count;
    }
}
