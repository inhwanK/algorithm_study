package algorithm_study.programers.level2;

import java.util.*;

// 오픈채팅방 - https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class Pro42888 {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap();
        Queue<String[]> messageQue = new LinkedList();

        for (int i = 0; i < record.length; i++) {
            String[] input = record[i].split(" ");

            String command = input[0];
            String id = input[1];

            String[] message = new String[2];
            message[0] = id;

            if (command.equals("Leave")) {
                message[1] = "님이 나갔습니다.";
                messageQue.add(message);
                continue;
            }

            String nick = input[2];

            if (command.equals("Enter")) {
                message[1] = "님이 들어왔습니다.";
                userMap.put(id, nick);
                messageQue.add(message);
                continue;
            }

            userMap.put(id, nick);
        }

        List<String> resultList = new ArrayList();

        while (!messageQue.isEmpty()) {
            String[] message = messageQue.poll();
            String result = userMap.get(message[0]) + message[1];

            resultList.add(result);
        }

        String[] answer = new String[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}
