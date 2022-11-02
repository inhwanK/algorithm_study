package algorithm_study.programers.level2;

// k진수에서 소수 개수 구하기 - https://school.programmers.co.kr/learn/courses/30/lessons/92335
public class Pro92335 {
    public int solution(int n, int k) {
        int answer = 0;

        String str = "";
        while (n != 0) {
            str += n % k;
            n /= k;
        }

        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '0') {
                if (temp.length() == 0) {
                    continue;
                }

                if (isPrime(Long.parseLong(temp))) {
                    answer++;
                }
                temp = "";
                continue;
            }

            temp += c;

            if (i == 0) {
                if (isPrime(Long.parseLong(temp))) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPrime(Long num) {
        if (num == 1) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}


class Pro92335Answer {
    public int solution(int n, int k) {
        int answer = 0;

        String toK = toK(n, k);
        answer = calc(toK);

        return answer;
    }

    public String toK(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n >= k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);

        return sb.reverse().toString();
    }

    public int calc(String toK) {
        int result = 0;

        String[] splits = toK.split("0");
        for (String sp : splits) {
            if (sp == null || sp.length() == 0 || sp == "") {
                continue;
            }
            if (isPrime(Long.parseLong(sp))) {
                result++;
            }
        }

        return result;
    }

    public boolean isPrime(long value) {
        if (value == 0 || value == 1) {
            return false;
        }
        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}
