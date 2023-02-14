package algorithm_study.programers.level2;

import java.util.*;

// [3차] 방금그곡 - https://school.programmers.co.kr/learn/courses/30/lessons/17683
public class Pro17683 {
    class Music implements Comparable<Music> {
        int index;
        int time;
        String title;

        public Music(int index, int time, String title) {
            this.index = index;
            this.time = time;
            this.title = title;
        }

        public int compareTo(Music o) {
            if (o.time == this.time) {
                return this.index - o.index;
            }
            return o.time - this.time;
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        PriorityQueue<Music> heap = new PriorityQueue();

        m = replaceSound(m);
        int index = 0;
        for (String music : musicinfos) {
            String[] target = music.split(",");

            // 시간 계산 로직
            int minute = calcMinute(target[0], target[1]);
            String title = target[2];
            // 음을 음악이 재생된 시간만큼 늘리거나 줄이는 로직
            target[3] = replaceSound(target[3]);
            String sound = play(target[3], minute);

            if (sound.contains(m)) {
                heap.add(new Music(index, minute, title));
            }

            index++;
        }

        if (!heap.isEmpty()) {
            answer = heap.poll().title;
        }

        return answer;
    }

    private String replaceSound(String sound) {
        sound = sound.replace("A#", "H");
        sound = sound.replace("C#", "I");
        sound = sound.replace("D#", "J");
        sound = sound.replace("F#", "K");
        sound = sound.replace("G#", "L");

        return sound;
    }

    private String play(String sound, int minute) {
        if (sound.length() < minute) {
            // 자바 11버전부터 repeat 메서드 가능
//            sound = sound.repeat((minute / sound.length()) + 1);
        }
        return sound.substring(0, minute);
    }

    private int calcMinute(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int startHour = Integer.parseInt(start[0]);
        int startMin = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMin = Integer.parseInt(end[1]);

        return endMin + ((endHour - startHour) * 60) - startMin;
    }
}

class Pro17683Answer {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (int inx = 0; inx < musicinfos.length; inx++) {

            String[] info = musicinfos[inx].split(",");

            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
            int t = end - start;

            if (t > time) {
                info[3] = edit(info[3]);
                StringBuffer sb = new StringBuffer();
                for (int jnx = 0; jnx < t; jnx++) {
                    sb.append(info[3].charAt(jnx % (info[3].length())));
                }
                if (sb.toString().indexOf(m) >= 0) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
    }

    public String edit(String m) {

        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
    }
}