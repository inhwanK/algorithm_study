package algorithm_study.programers.level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// [3차] 파일명 정렬 - https://school.programmers.co.kr/learn/courses/30/lessons/17686
public class Pro17686 {
    class Name implements Comparable<Name> {
        String head;
        String number;
        String tail;

        public Name(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public int compareTo(Name o) {
            String th = this.head.toLowerCase();
            String oh = o.head.toLowerCase();

            if (th.equals(oh)) {
                int tn = Integer.parseInt(this.number);
                int on = Integer.parseInt(o.number);
                if (tn == on) {
                    return 0;
                }
                return tn - on;
            }
            return th.compareTo(oh);
        }

        public String toString() {
            return head + number + tail;
        }
    }

    public String[] solution(String[] files) {

        ArrayList<Name> list = new ArrayList();

        for (String file : files) {
            int start = -1;
            int end = -1;
            for (int i = file.length() - 1; i > 0; i--) {

                char now = file.charAt(i);
                char next = file.charAt(i - 1);
                if (now < '0' || now > '9') {
                    if (next >= '0' && next <= '9') {
                        end = i;
                    }
                }

                if (next < '0' || next > '9') {
                    if (now >= '0' && now <= '9') {
                        start = i;
                    }
                }
            }

            if (end == -1) {
                end = file.length();
            }

            String head = file.substring(0, start);
            String number = file.substring(start, end);
            String tail = file.substring(end);

            list.add(new Name(head, number, tail));
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).toString();
        }

        return answer;
    }
}

// Character.isDigit 쓴거 배우면 좋을 듯
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new StrCmp());
        return files;
    }

    private class StrCmp implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();
            int i = 0;
            int j = 0;
            while (i < s1.length() && !Character.isDigit(s1.charAt(i))) ++i;
            while (j < s2.length() && !Character.isDigit(s2.charAt(j))) ++j;
            int cmp1 = s1.substring(0, i).compareTo(s2.substring(0, j));
            if (cmp1 != 0) return cmp1;
            int startI = i;
            int startJ = j;
            while (i < s1.length() && Character.isDigit(s1.charAt(i))) ++i;
            while (j < s2.length() && Character.isDigit(s2.charAt(j))) ++j;
            int num1 = Integer.parseInt(s1.substring(startI, i));
            int num2 = Integer.parseInt(s2.substring(startJ, j));
            return num1 - num2;
        }
    }
}

// 정규표현식을 사용한 풀이
class Pro17686Answer2 {
    public String[] solution(String[] files) {
        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                Matcher m1 = p.matcher(s1.toLowerCase());
                Matcher m2 = p.matcher(s2.toLowerCase());
                m1.find();
                m2.find();

                if (!m1.group(1).equals(m2.group(1))) {
                    return m1.group(1).compareTo(m2.group(1));
                } else {
                    return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
                }
            }
        });

        return files;
    }
}

class Pro17686Answer3 {
    public String[] solution(String[] files) {
        List<FileName> fileNameList = new ArrayList<>();
        String head, number, tail;

        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(s);
            if (m.find()) {
                number = m.group();
                int numberStartIndex = s.indexOf(number);
                head = s.substring(0, numberStartIndex);
                int numberEndIndex = numberStartIndex + number.length() - 1;
                if (numberEndIndex + 1 > s.length() - 1) {
                    tail = "";
                } else {
                    tail = s.substring(numberEndIndex + 1);
                }
                fileNameList.add(new FileName(head, number, tail));
            }
        }

        fileNameList.sort(Comparator.comparing(FileName::getHead).thenComparing(Comparator.naturalOrder()));

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileNameList.get(i).toString();
        }
        return answer;
    }

    public static class FileName implements Comparable<FileName> {
        String head;
        String number;
        String tail;

        public FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head.toUpperCase();
        }

        @Override
        public String toString() {
            return head + number + tail;
        }

        @Override
        public int compareTo(FileName o) {
            int mine = Integer.parseInt(this.number);
            int yours = Integer.parseInt(o.number);
            return mine - yours;
        }
    }
}