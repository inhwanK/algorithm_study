package algorithm_study.programers;

// 다트 게임
// https://programmers.co.kr/learn/courses/30/lessons/17682
public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        char[] arr = dartResult.toCharArray();

        System.out.println(arr);

        int count = -1;

        int i = 0;
        while(i < arr.length){
            if(arr[i] == '1' && arr[i+1] == '0'){
                count++;
                score[count] = 10;
                System.out.println(score[count]);
                i++;
            } else if(arr[i] >= '0' && arr[i] <= '9'){
                count++;
                score[count] = Integer.parseInt(arr[i] + "");
                System.out.println(score[count]);
            } else if(arr[i] == 'D'){
                score[count] = (int) Math.pow(score[count], 2);
            } else if(arr[i] == 'T'){
                score[count] = (int) Math.pow(score[count], 3);
            } else if(arr[i] == '#'){
                score[count] = score[count] * (-1);
            } else if(arr[i] == '*' && count == 0){
                score[count] = score[count] * 2;
            } else if(arr[i] == '*' && count > 0){
                score[count] = score[count] * 2;
                score[count - 1] = score[count - 1] * 2;
            }

            i++;
        }


        answer = score[0] + score[1] +score[2];

        return answer;
    }
}
