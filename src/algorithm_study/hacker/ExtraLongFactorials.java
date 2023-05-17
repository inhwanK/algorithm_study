package algorithm_study.hacker;

import java.math.*;
import java.util.*;

// https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true
public class ExtraLongFactorials {
    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        List<BigInteger> list = new ArrayList();
        list.add(new BigInteger("1"));
        list.add(new BigInteger("1"));

        for(int i = 2; i <= n; i++) {
            list.add(list.get(i - 1).multiply(new BigInteger(String.valueOf(i))));
        }
        System.out.println(list.get(n));
    }
}
