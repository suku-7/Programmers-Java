import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0; // 현재 다리 위 트럭들의 무게 총합
        Queue<Integer> bridge = new LinkedList<>(); // 다리를 큐로 표현 (각 시간마다 다리 위 트럭 무게 또는 0)

        // 다리를 길이만큼 0으로 채움 (초기에는 트럭이 없으므로)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0; // 총 걸린 시간
        int truckIndex = 0; // 다음에 올라올 트럭의 인덱스

        // 모든 트럭이 다리에 올라올 때까지 반복
        while (truckIndex < truck_weights.length) {
            bridgeWeight -= bridge.poll(); // 한 칸 전진하며 맨 앞 트럭 제거 (또는 0 제거)
            
            int truckWeight = truck_weights[truckIndex]; // 다음 트럭 무게
            // 현재 다리 무게 + 다음 트럭 무게가 허용 무게 이하라면
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);     // 트럭 다리에 올림
                bridgeWeight += truckWeight; // 다리 무게 갱신
                truckIndex++;                // 다음 트럭으로 이동
            } else {
                bridge.add(0); // 트럭을 올릴 수 없으면 빈 공간(0)을 다리에 추가
            }

            time++; // 시간 증가
        }

        // 마지막 트럭이 완전히 다리를 지나갈 때까지 시간 추가
        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time; // 총 소요 시간 반환
    }
}
