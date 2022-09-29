package algorithm_study.codility;

// BinaryGap - https://app.codility.com/c/run/trainingA6CDD6-GFT/
public class BinaryGap {
    public int solution(int N) {

        String binStr = "";
        while(N != 0) {
            binStr += N % 2;
            N /= 2;
        }

        String[] output = binStr.split("1");
        int result = 0;
        for(int i = 1; i < output.length; i++) {
            if(output[i].contains("0")) {
                result = Math.max(result, output[i].length());
            }
        }
        return result;
    }
}
