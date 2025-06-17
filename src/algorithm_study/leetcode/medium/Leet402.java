package algorithm_study.leetcode.medium;

// Remove K Digits - https://leetcode.com/problems/remove-k-digits/
public class Leet402 {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();
        for (char digit : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        while(k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        while(stack.length() > 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }

        if(stack.length() == 0) {
            return "0";
        }

        return stack.toString();
    }
}
