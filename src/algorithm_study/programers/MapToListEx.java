package algorithm_study.programers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Map 정렬 실습
 * <br> 참고 릳크 : https://codechacha.com/ko/java-sort-map
 */
public class MapToListEx {

    public static void main(String[] args) {
        Map<String, Integer> testMap = new HashMap<>();

        // Map에 데이터 추가
        testMap.put("apple", 1);
        testMap.put("orange", 2);
        testMap.put("pineapple", 4);
        testMap.put("strawberry", 5);
        testMap.put("melon", 3);
    }
}
