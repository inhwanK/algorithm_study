package algorithm_study.programers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 베스트앨범 - https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class Pro42579 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> sumMap = new HashMap();

        for (int i = 0; i < genres.length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르 order 만들기
        ArrayList<String> genreOrder = new ArrayList();
        while (sumMap.size() != 0) {
            int max = 0;
            String maxKey = "";
            for (String genre : sumMap.keySet()) {
                if (sumMap.get(genre) > max) {
                    max = sumMap.get(genre);
                    maxKey = genre;
                }
            }
            genreOrder.add(maxKey);
            sumMap.remove(maxKey);
        }


        ArrayList<Song> result = new ArrayList();
        for (String genre : genreOrder) {

            ArrayList<Song> songList = new ArrayList();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    songList.add(new Song(i, plays[i], genres[i]));
                }
            }
            Collections.sort(songList, Collections.reverseOrder());
            result.add(songList.get(0));
            if (songList.size() != 1) {
                result.add(songList.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i).id;
        }

        return answer;
    }
}

class Song implements Comparable<Song> {

    int id;
    int plays;
    String genre;

    public Song(int id, int plays, String genre) {
        this.id = id;
        this.plays = plays;
        this.genre = genre;
    }

    public int compareTo(Song o) {
        return Integer.compare(this.plays, o.plays);
    }
}