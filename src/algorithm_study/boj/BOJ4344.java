package algorithm_study.boj;

import java.io.*;
import java.util.StringTokenizer;

// %% 를 써야 %가 출력된다..
// 평균은 넘겠지 - https://www.acmicpc.net/problem/4344
public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] arr = new int[num];
            for(int j = 0; j < num; j++) {
                int score = Integer.parseInt(st.nextToken());
                sum += score;
                arr[j] = score;
            }
            float average = (float) sum / num;

            int count = 0;
            for(int j = 0; j < num; j++) {
                if(arr[j] > average) {
                    count++;
                }
            }

            float result = ((float) count / num) * 100;
            System.out.printf("%.3f%%\n", result);

        }
    }
}

// 상위 정답 - https://www.acmicpc.net/source/12832472
class BOJ4344Answer {

    //4344 평균은 넘겠지
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int count = Integer.parseInt(bf.readLine());

            // 외부 for문
            for (int i=1; i<=count; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int innerCount = Integer.parseInt(st.nextToken());
                int[] group = new int[innerCount];
                int sum = 0;
                // 내부 for문
                for (int j=0; j<innerCount; j++) {
                    group[j] = Integer.parseInt(st.nextToken());
                    sum += group[j];
                }
                int avg = sum/innerCount;
                int check = 0;
                for (int k : group) {
                    if(Integer.compare(k, avg) > 0) {
                        check += 1;
                    }
                } // 내부 for문 end
                bw.write(String.format("%.3f", check*100.000/innerCount)+"%\n");
            } // 외부 for문 end
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}