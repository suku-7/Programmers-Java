import java.util.*;

class Solution {
    // 최종 경로를 담을 리스트
    List<String> answer = new ArrayList<>();
    // 항공권 사용 여부를 체크하는 배열
    boolean[] visited;
    // 경로를 찾았는지 여부
    boolean found = false;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];

        // 티켓을 출발지 기준으로 정렬, 같으면 도착지 기준으로 정렬 (알파벳 순서)
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        // 경로를 담을 리스트 생성 및 시작 공항 "ICN" 추가
        List<String> path = new ArrayList<>();
        path.add("ICN");

        // DFS 탐색 시작
        dfs("ICN", tickets, path, 0);

        // 리스트를 배열로 변환하여 반환
        return answer.toArray(new String[0]);
    }

    private void dfs(String current, String[][] tickets, List<String> path, int count) {
        // 이미 경로를 찾은 경우 더 이상 탐색하지 않음 (백트래킹 중단)
        if (found) return;

        // 모든 티켓을 사용한 경우 경로 저장하고 탐색 종료
        if (count == tickets.length) {
            answer = new ArrayList<>(path); // 경로 복사
            found = true;
            return;
        }

        // 현재 위치에서 갈 수 있는 티켓들을 탐색
        for (int i = 0; i < tickets.length; i++) {
            // 아직 사용하지 않았고, 출발지가 현재 위치인 티켓인 경우
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true; // 티켓 사용 표시
                path.add(tickets[i][1]); // 도착지 경로에 추가
                dfs(tickets[i][1], tickets, path, count + 1); // 다음 공항으로 DFS
                path.remove(path.size() - 1); // 백트래킹
                visited[i] = false; // 티켓 다시 사용 가능하게 만듦
            }
        }
    }
}
