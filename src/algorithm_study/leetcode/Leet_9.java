package algorithm_study.leetcode;

import java.util.ArrayList;

// Palindrome Number - https://leetcode.com/problems/palindrome-number/
public class Leet_9 {
    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        int size = input.length();
        for (int i = 0; i < size / 2; i++) {
            if (input.charAt(i) != input.charAt(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

class Leet_9FollowUp {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}

class Leet_9Answer {
    public boolean isPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
