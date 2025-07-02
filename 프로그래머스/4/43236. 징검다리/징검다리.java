import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 위치 정렬
        Arrays.sort(rocks);

        int left = 1; // 최소 거리
        int right = distance; // 최대 거리
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 이번 탐색에서 설정할 "최소 거리"
            int removed = 0; // 제거한 바위 개수
            int prev = 0; // 이전 바위 또는 출발지점 위치

            // 바위 사이의 거리 확인
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    // 현재 바위와 이전 지점 사이 거리가 mid보다 작으면 바위 제거
                    removed++;
                } else {
                    // mid 이상이면 바위를 두고 다음 구간 체크
                    prev = rocks[i];
                }
            }

            // 마지막 도착 지점과 마지막 바위 사이 거리도 확인
            if (distance - prev < mid) {
                removed++;
            }

            // 제거한 바위 수가 n보다 많으면 mid 값이 너무 큼 → 줄이기
            if (removed > n) {
                right = mid - 1;
            } else {
                // mid 값으로도 조건 만족 → 더 큰 거리도 시도
                answer = mid; // 최대값 찾기
                left = mid + 1;
            }
        }

        return answer;
    }
}
