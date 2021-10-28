package algorithm_study.programers;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

	public int solution(String[][] clothes) {

		Map<String, Integer> clothEa = new HashMap<String, Integer>();
		int answer = 1;

		for (int i = 0; i < clothes.length; i++) {
			clothEa.put(clothes[i][1], clothEa.getOrDefault(clothes[i][1], 0) + 1);
		}

		for (String key : clothEa.keySet()) {
			answer *= clothEa.get(key) + 1;
		}

		// (종류별 개수 서로 곱한 값)+(전체 개수)

		return answer - 1;
	}

}
