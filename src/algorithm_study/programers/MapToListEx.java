package algorithm_study.programers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Map 정렬 실습
 * <br> 참고 링크 :
 * <br> https://codechacha.com/ko/java-sort-map
 * <br> https://developer-talk.tistory.com/394
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

        Stream<Map.Entry<String, Integer>> streamMap = testMap.entrySet().stream();
        List<Map.Entry<String, Integer>> list = streamMap.collect(Collectors.toList());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getKey();
            System.out.println(answer[i]);
        }
    }
}
