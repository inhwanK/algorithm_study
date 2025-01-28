package algorithm_study.leetcode.easy;

import java.util.Arrays;

// Valid Anagram - https://leetcode.com/problems/valid-anagram/description/?source=submission-ac
public class Leet242 {
    public static void main(String[] args) {
        // answer 1 배열을 이용한 풀이 O(n)
        isAnagram("asdf", "dfsa");

        // answer 2 sorting으로 풀이 O(nlogn)
        isAnagramBySort("asdfe", "afesa");
    }

    public static boolean isAnagram(String s, String t) {

        int size = 123 - 97;
        int[] letters = new int[size];
        for(int i = 0; i < s.length(); i++) {
            letters[(int) (s.charAt(i) - 'a')]++;
        }

        for(int i = 0; i < t.length(); i++) {
            letters[(int) (t.charAt(i) - 'a')]--;
        }

        return isAna(letters);
    }

    public static boolean isAna(int[] letters) {
        for(int i = 0; i < letters.length; i++) {
            if(letters[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramBySort(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}

