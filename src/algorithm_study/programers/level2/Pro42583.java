package algorithm_study.programers.level2;

import java.util.*;

// 다리를 지나는 트럭 - https://school.programmers.co.kr/learn/courses/30/lessons/42583
public class Pro42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;

        Queue<Integer> que = new LinkedList();

        que.add(truck_weights[index]);
        weight -= truck_weights[index];
        index++;
        answer++;

        while (!que.isEmpty()) {
            if (answer >= bridge_length) {
                int truck = que.poll();
                weight += truck;
            }

            if (index != truck_weights.length && weight < truck_weights[index]) {
                que.add(0);
            }

            if (index != truck_weights.length && weight >= truck_weights[index]) {
                que.add(truck_weights[index]);
                weight -= truck_weights[index];
                index++;
            }
            answer++;
        }
        return answer;
    }

    public int solution_1(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> truckStack = new Stack<>();
        Map<Integer, Integer> bridgeMap = new HashMap<>();

        for (int i = truck_weights.length - 1; i >= 0; i--)
            truckStack.push(truck_weights[i]);

        int answer = 0;
        int sum = 0;
        while (true) {
            answer++;

            if (bridgeMap.containsKey(answer))
                bridgeMap.remove(answer);

            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            if (!truckStack.isEmpty())
                if (sum + truckStack.peek() <= weight)
                    bridgeMap.put(answer + bridge_length, truckStack.pop());

            if (bridgeMap.isEmpty() && truckStack.isEmpty())
                break;


        }
        return answer;
    }

    public int solution_2(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }
}
