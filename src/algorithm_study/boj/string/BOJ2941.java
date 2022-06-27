package algorithm_study.boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ljes=njak
ddz=z=
nljj
c=c=
dz=ak
*/

//크로아티아 알파벳 - https://www.acmicpc.net/problem/2941
public class BOJ2941 {
    public static String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        for (int i = 0; i < arr.length; i++) {
            s = s.replace(arr[i], "0");
        }
        System.out.println(s.length());

        br.close();
    }
}
