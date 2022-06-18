package algorithm_study.tic.chap13;

// 괄호 변환
// 정답 코드와 동일함
public class Q18 {
    // 균형잡힌 괄호 문자열 판단
    public int balencedIndex(String p) {
        int count = 0; // 여는 괄호 개수
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') count++;
            else count--;

            if(count == 0)  return i;
        }
        return -1;
    }

    // 올바른 괄호 문자열 판단
    public boolean checkCorrect(String u) {
        int count = 0;
        for(int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') count++;
            else {
                if (count == 0){
                    return false;
                }
                count -= 1;
            }
        }
        return true;
    }

    // 이걸 재귀로도 쓰는구나......
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return answer;
        int index = balencedIndex(p);
        String u = p.substring(0,index + 1);

        String v = p.substring(index + 1);

        if(checkCorrect(u)) {
            answer = u + solution(v);
        } else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1);
            String temp = "";
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}
