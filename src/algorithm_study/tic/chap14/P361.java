package algorithm_study.tic.chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://st-lab.tistory.com/243
public class P361 {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        int[] arr = new int[N + 1];
        for(int i = 0; i < stages.length; i++){
            if(stages[i] > N) continue;
            else arr[stages[i]]++;
        }

        int challenge = stages.length;
        List<Stage> stageList = new ArrayList<>();
        for(int i = 1; i <= N; i++){

            challenge = challenge - arr[i - 1];
            float ratio = (float) arr[i] / challenge;

            if(arr[i] == 0){
                System.out.println(ratio);
                stageList.add(new Stage(i, 0));
                continue;
            }

            System.out.println("2 > "+ ratio);
            stageList.add(new Stage(i, ratio));
        }

        Collections.sort(stageList, (o1, o2) -> Float.compare(o2.getRatio(), o1.getRatio()));

        answer =  new int[stageList.size()];
        for(int i = 0; i < stageList.size(); i++){
            answer[i] = stageList.get(i).getStageNum();
        }

        return answer;
    }

}

class Stage {

    private int stageNum;
    private float ratio;
    String test;

    public Stage(int stageNum, float ratio) {
        this.stageNum = stageNum;
        this.ratio = ratio;
    }

    public int getStageNum() {
        return this.stageNum;
    }

    public float getRatio() {
        return this.ratio;
    }
}