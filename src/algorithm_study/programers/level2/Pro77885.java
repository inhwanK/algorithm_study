package algorithm_study.programers.level2;

// 2개 이하로 다른 비트 - https://school.programmers.co.kr/learn/courses/30/lessons/77885
public class Pro77885 {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }
}
