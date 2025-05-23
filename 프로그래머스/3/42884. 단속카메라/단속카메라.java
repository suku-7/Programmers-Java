import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 차량의 경로를 끝나는 지점(route[1]) 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int count = 0; // 설치된 카메라 수
        int last = Integer.MIN_VALUE; // 마지막으로 설치된 카메라의 위치

        for (int[] route : routes) {
            // 현재 차량의 진입지점(route[0])이 last 이후라면,
            // 기존 카메라로는 단속이 불가능하므로 새 카메라 설치
            if (last >= route[0] && last <= route[1]) continue;

            // 현재 차량의 종료지점에 카메라 설치
            last = route[1];
            count++;
        }

        return count; // 총 설치한 카메라 수 반환
    }
}
