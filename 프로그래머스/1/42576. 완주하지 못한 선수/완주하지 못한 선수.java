import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>(); // 참가자 이름과 인원 수를 저장할 해시맵

        // 참가자 배열을 순회하며 이름별로 인원 수를 저장
        for (String name : participant) {
            count.putIfAbsent(name, 0); // 이름이 없으면 0으로 초기화
            count.put(name, count.get(name) + 1); // 참가자 수 증가
        }

        // 완주자 배열을 순회하며 해당 이름의 참가자 수 감소
        for (String name : completion) {
            int v = count.get(name) - 1; // 이름에 해당하는 수 하나 감소
            count.put(name, v); // 감소된 수로 갱신
            if (v == 0) count.remove(name); // 만약 수가 0이 되면 맵에서 제거
        }

        // 맵에 남아있는 단 한 사람 (완주하지 못한 사람)의 이름 반환
        return count.keySet().iterator().next();
    }
}
