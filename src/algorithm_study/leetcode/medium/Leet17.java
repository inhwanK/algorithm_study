package algorithm_study.leetcode.medium;

import java.util.*;

// 17. Letter Combinations of a Phone Number - https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?source=submission-ac
public class Leet17 {
    // 숫자가 표현할 수 있는 모든 가능한 문자 조합을 반환해라
    // 답은 any order로
    // any order가 뭔데? ... 그냥 조합으로 해도 된다는 의미였음....
    List<String> result = new ArrayList();

    public List<String> letterCombinations(String digits) {

        // 주어진 번호들을 가지고 순서대로 순열 만들기.
        // 이 때 각 순열의 길이는 = digits.length()
        String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String[] pressedLetters = new String[digits.length()];

        // pressedLetters 에 눌린 값 순서로 letters 옮기기
        for (int i = 0; i < pressedLetters.length; i++) {
            char pressedLetter = digits.charAt(i);
            pressedLetters[i] = letters[pressedLetter - '0'];
        }

        // 순열 만드는
        per("", pressedLetters, 0);
        return result;
    }

    private void per(String target, String[] pressedLetters, int depth) {
        if (depth == pressedLetters.length) {
            if ("".equals(target)) {
                return;
            }
            result.add(target);
            return;
        }

        String now = pressedLetters[depth];
        for (int i = 0; i < now.length(); i++) {
            per(target + now.charAt(i), pressedLetters, depth + 1);
        }
        return;
    }
}
