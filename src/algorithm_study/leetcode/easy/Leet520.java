package algorithm_study.leetcode.easy;

// 520. Detect Capital - https://leetcode.com/problems/detect-capital/submissions/1725692465/
public class Leet520 {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) return true;
        if (word.equals(word.toLowerCase())) return true;
        if (Character.isUpperCase(word.charAt(0)) &&
                word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        return false;
    }
}
