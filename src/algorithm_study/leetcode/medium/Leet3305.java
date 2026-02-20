package algorithm_study.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// 3305. Count of Substrings Containing Every Vowel and K Consonants I - https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet3305 {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> vowelCount = new HashMap<>();
            int consonants = 0;

            for (int j = i; j < n; j++) {
                char c = word.charAt(j);

                if(isVowel(c)) {
                    vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
                } else {
                    consonants++;
                    if (consonants > k) break;
                }

                if(vowelCount.size() == 5 && consonants == k) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
