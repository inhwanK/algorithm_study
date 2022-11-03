package algorithm_study.programers.level2;

import java.util.*;

// 주차 요금 계산 - https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class Pro92341 {

    class ParkingFee implements Comparable<ParkingFee> {
        String carNum;
        Integer fee;

        public ParkingFee(String carNum, Integer fee) {
            this.carNum = carNum;
            this.fee = fee;
        }

        public int compareTo(ParkingFee o) {
            return carNum.compareTo(o.carNum);
        }
    }

    public int[] solution(int[] fees, String[] records) {

        // 자동차별 총 주차 시간
        Map<String, Integer> carParkingTime = new HashMap();
        Map<String, Integer> carInTime = new HashMap();

        for (String record : records) {
            String[] recArr = record.split(" ");

            int time = getMinute(recArr[0]);
            String carNum = recArr[1];

            if (recArr[2].equals("IN")) {
                carInTime.put(carNum, time);

            } else {
                int parkingTime = time - carInTime.get(carNum);
                parkingTime = carParkingTime.getOrDefault(carNum, 0) + parkingTime;
                carParkingTime.put(carNum, parkingTime);

                carInTime.remove(carNum);
            }

        }

        for (String carNum : carInTime.keySet()) {
            int parkingTime = getMinute("23:59") - carInTime.get(carNum);
            parkingTime = carParkingTime.getOrDefault(carNum, 0) + parkingTime;
            carParkingTime.put(carNum, parkingTime);

            // carInTime.remove(carNum); 이거 왜 런타임?
        }

        List<ParkingFee> result = new ArrayList();
        for (String carNum : carParkingTime.keySet()) {
            int fee = calcParkingFee(carParkingTime.get(carNum), fees);
            ParkingFee pf = new ParkingFee(carNum, fee);
            result.add(pf);
        }

        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).fee;
        }

        return answer;
    }

    private int calcParkingFee(int parkingTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (parkingTime <= basicTime) {
            return basicFee;
        }

        int time = (int) Math.ceil((float) (parkingTime - basicTime) / unitTime);

        return basicFee + (time * unitFee);
    }

    private int getMinute(String time) {
        String[] sp = time.split(":");
        int minute = 0;

        minute += Integer.parseInt(sp[0]) * 60;
        minute += Integer.parseInt(sp[1]);

        return minute;
    }
}