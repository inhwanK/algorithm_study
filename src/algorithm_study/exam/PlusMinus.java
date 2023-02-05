package algorithm_study.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 더하고 빼기
public class PlusMinus {
    public static void main(String[] args) throws IOException {

        PlusMinus pm = new PlusMinus();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = pm.getAnswer(Integer.parseInt(br.readLine()));
    }

    private String getAnswer(int n) {
        int key  = getNumber(n);
        if(key % 9 == 0) {
            return "apple";
        }
        return "";
    }

    private int getNumber(int n) {

        int target = n;
        while (n > 0) {
            target -= n % 10;
            n /= 10;
        }

        if(target <= 100) {
            return target;
        }
        return getNumber(target);
    }
}
