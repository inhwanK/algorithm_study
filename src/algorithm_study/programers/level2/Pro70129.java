package algorithm_study.programers.level2;

// 이진 변환 반복하기 - https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Pro70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int countZero = 0;
        while (!s.equals("1")) {
            int pre = s.length();
            int size = s.replace("0", "").length();
            s = Integer.toBinaryString(size);
            countZero += pre - size;
            count++;
        }
        answer[0] = count;
        answer[1] = countZero;
        return answer;
    }

    public int[] solution_answer(String s) {
        int[] answer = new int[2];
        int temp;
        while (!s.equals("1")) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s );
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;
    }
}
