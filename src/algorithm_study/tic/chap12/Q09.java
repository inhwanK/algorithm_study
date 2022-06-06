package algorithm_study.tic.chap12;

public class Q09 {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {

            String compressed = "";
            String prev = s.substring(0, i);
            int count = 1;

            for (int j = i; j < s.length(); j += i) {

                String sub = "";
                for (int k = j; k < j + i; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }

                if (prev.equals(sub)) count += 1;
                else {
                    compressed += (count >= 2) ? count + prev : prev;
                    sub = "";

                    for (int k = j; k < j + i; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }

                    prev = sub;
                    count = 1;
                }
            }

            compressed += (count >= 2) ? count + prev : prev;
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
