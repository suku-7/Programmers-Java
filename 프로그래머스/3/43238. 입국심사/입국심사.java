import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 최소 시간: 1분, 최대 시간: 가장 느린 심사관이 모두를 처리할 경우
        long left = 1;
        int maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        long right = (long) maxTime * n;
        long answer = right;

        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;

            // 현재 시간(mid) 동안 각 심사관이 몇 명 심사할 수 있는지 합산
            for (int time : times) {
                people += mid / time;
            }

            if (people >= n) {
                // n명 이상 처리 가능 → 시간을 줄일 수 있음
                answer = mid; // 최솟값 찾기
                right = mid - 1;
            } else {
                // 처리 인원이 부족 → 시간을 늘려야 함
                left = mid + 1;
            }
        }

        return answer;
    }
}
