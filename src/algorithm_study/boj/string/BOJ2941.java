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

// 이것도 바이트로 받아버려?
// 상위 코드 - https://www.acmicpc.net/source/11463976
class BOJ2941Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '=':
                    switch (str.charAt(i - 1)) {
                        case 'c': case 's': count++; break;
                        case 'z':
                            if(i > 1 && str.charAt(i - 2) == 'd') {
                                count += 2;
                                break;
                            } else {
                                count ++;
                                break;
                            }
                        default: break;
                    }
                    break;
                case '-':
                    switch (str.charAt(i - 1)) {
                        case 'c': case 'd': count++; break;
                        default: break;
                    }
                    break;
                case 'j':
                    switch (str.charAt(i - 1)) {
                        case 'l': case 'n': count++; break;
                        default: break;
                    }
                    break;
                default: break;
            }
        }
        System.out.print(str.length() - count);
    }
}