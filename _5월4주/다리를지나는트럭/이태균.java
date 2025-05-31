package _5월4주.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class 이태균 {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int current_weight = 0;
        int time = 0;

        int len = truck_weights.length;
        for (int i = 0; i < len; i++) {
            int current_truck = truck_weights[i];

            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(current_truck);
                    current_weight += current_truck;
                    time++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    current_weight -= bridge.poll();
                } else {
                    if (current_weight + current_truck <= weight) {
                        bridge.add(current_truck);
                        current_weight += current_truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }

}