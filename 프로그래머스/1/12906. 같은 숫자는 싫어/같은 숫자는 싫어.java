import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 결과를 저장할 큐 선언
        Queue<Integer> queue = new LinkedList<>();
        
        // 이전에 본 숫자를 저장할 변수, 초기값은 배열에 나올 수 없는 값(-1)
        int prev = -1;

        // 입력 배열을 순회하면서 연속된 중복을 제거
        for (int num : arr) {
            if (num != prev) { // 이전 값과 다르면 큐에 추가
                queue.add(num);
                prev = num; // 현재 숫자를 이전 숫자로 갱신
            }
        }

        // 큐의 크기만큼 정답 배열 생성
        int[] answer = new int[queue.size()];
        int i = 0;

        // 큐에 저장된 값을 순서대로 꺼내서 정답 배열에 저장
        while (!queue.isEmpty()) {
            answer[i] = queue.poll();
            i++;
        }

        // 연속된 숫자를 제거한 배열 반환
        return answer;
    }
}
