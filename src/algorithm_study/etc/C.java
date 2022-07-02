package algorithm_study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 8
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] a = new long[n];
        long[] b = new long[n];

        long[][] result = new long[n][n];

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        a[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b[0] = Long.parseLong(st.nextToken());
        if(a[0] == b[0]) count++;
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] + Long.parseLong(st.nextToken());
            if(a[i] == b[i]) count++;
        }
        for (int start = 0; start < n - 1; start++) {
            for (int end = start + 1; end < n; end++) {
                if (a[end] - a[start] == b[end] - b[start]) {
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}