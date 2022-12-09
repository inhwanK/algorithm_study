package algorithm_study.programers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 방문 길이 - https://school.programmers.co.kr/learn/courses/30/lessons/49994
public class Pro49994 {
    class Dir {
        int departX;
        int departY;
        int arriveX;
        int arriveY;

        public Dir(int departX, int departY, int arriveX, int arriveY) {
            this.departX = departX;
            this.departY = departY;
            this.arriveX = arriveX;
            this.arriveY = arriveY;
        }

        public boolean equals(Object o) {
            Dir other = (Dir) o;
            if (this.departX == other.departX && this.departY == other.departY) {
                if (this.arriveX == other.arriveX && this.arriveY == other.arriveY) {
                    return true;
                }
            }

            if (this.departX == other.arriveX && this.departY == other.arriveY) {
                if (this.arriveX == other.departX && this.arriveY == other.departY) {
                    return true;
                }
            }

            return false;
        }

        public int hashCode() {
            return 1;
        }
    }

    public int solution(String dirs) {
        HashSet<Dir> set = new HashSet();
        char[] dirsArr = dirs.toCharArray();

        int preX = 5;
        int preY = 5;
        int nowX = 5;
        int nowY = 5;

        boolean flag = false;

        for (int i = 0; i < dirsArr.length; i++) {

            if (dirsArr[i] == 'U' && validCheck(preX - 1, preY)) {
                nowX = preX - 1;
                nowY = preY;
                set.add(new Dir(preX, preY, nowX, nowY));
                flag = true;
            }

            if (dirsArr[i] == 'D' && validCheck(preX + 1, preY)) {
                nowX = preX + 1;
                nowY = preY;
                set.add(new Dir(preX, preY, nowX, nowY));
                flag = true;
            }

            if (dirsArr[i] == 'L' && validCheck(preX, preY - 1)) {
                nowX = preX;
                nowY = preY - 1;
                set.add(new Dir(preX, preY, nowX, nowY));
                flag = true;
            }

            if (dirsArr[i] == 'R' && validCheck(preX, preY + 1)) {
                nowX = preX;
                nowY = preY + 1;
                set.add(new Dir(preX, preY, nowX, nowY));
                flag = true;
            }

            if (flag) {
                preX = nowX;
                preY = nowY;
            }

            flag = false;
        }

        return set.size();
    }

    public boolean validCheck(int x, int y) {
        if (x < 0 || y < 0 || x >= 11 || y >= 11) {
            return false;
        }
        return true;
    }
}

class Pro49994Answer {
    public int solution(String dirs) {
        Map<String, int[]> map = new HashMap<>();
        map.put("U", new int[]{0, 1});
        map.put("D", new int[]{0, -1});
        map.put("R", new int[]{1, 0});
        map.put("L", new int[]{-1, 0});

        String[] arr = dirs.split("");

        Set<String> set = new HashSet<>();
        int cx = 0;
        int cy = 0;

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            int x = map.get(s)[0];
            int y = map.get(s)[1];

            cx += x;
            cy += y;

            if (cx < -5 || cx > 5) {
                cx -= x;
                continue;
            }
            if (cy < -5 || cy > 5) {
                cy -= y;
                continue;
            }
            set.add("" + (cx - x) + "" + (cy - y) + "" + cx + "" + cy);
            set.add("" + cx + "" + cy + "" + (cx - x) + "" + (cy - y));
        }
        return set.size() / 2;
    }
}