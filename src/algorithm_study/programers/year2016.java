package algorithm_study.programers;

public class year2016 {
	public String solution(int a, int b) {
        String answer = "";
        
        int[] dayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        int day = 0;
        for(int i = 0; i < a-1; i++){
            day += dayOfMonth[i];
        }
        
        day = day + b;
        
        String[] dayOfWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        
        int date = day % 7;
        answer = dayOfWeek[date];
        
        return answer;
    }
}
