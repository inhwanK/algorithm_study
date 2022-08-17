package algorithm_study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Isomorphic Strings - https://leetcode.com/problems/isomorphic-strings/
public class Leet205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int size = s.length();

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else if (map.containsValue(tChar)) {
                return false;
            }
            map.put(sChar, tChar);
        }
        return true;
    }
}

// 배열로 바로 접근하는 거라 더 빠른 듯. Map의 시간 복잡도를 생각해보자
class Leet205Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }
}