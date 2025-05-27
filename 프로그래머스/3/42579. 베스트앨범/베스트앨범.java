import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> gSum = new HashMap<>(); // 장르별 총 재생 수 저장
        Map<String, List<int[]>> gMap = new HashMap<>(); // 장르별로 [고유번호, 재생수] 리스트 저장
        
        // 장르별 총 재생수와, 장르별 곡 정보 리스트 구성
        for (int i=0; i<genres.length; i++) {
            gSum.put(genres[i], gSum.getOrDefault(genres[i], 0)+plays[i]);
            
            // 해당 장르 리스트가 없다면 생성
            if (!gMap.containsKey(genres[i])) {
                gMap.put(genres[i], new ArrayList<>());
            }
            // [고유번호, 재생수] 저장
            gMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        // 장르를 총 재생 수 기준으로 내림차순 정렬
        List<String> gList = new ArrayList<>(gSum.keySet());
        gList.sort((a, b) -> gSum.get(b) - gSum.get(a));
        
        List<Integer> res = new ArrayList<>();
        // 각 장르별로 정렬 후 최대 2곡 선택
        for (String genre : gList) {
            List<int[]> list = gMap.get(genre);
            
            // 재생수 내림차순, 같으면 고유번호 오름차순 정렬
            list.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);
            
            // 가장 많이 재생된 곡 1개 추가
            res.add(list.get(0)[0]);
            
            // 두 번째 곡이 있다면 추가
            if (list.size() > 1) {
                res.add(list.get(1)[0]);
            }
        }
        // List<Integer> → int[] 변환
        return res.stream().mapToInt(i -> i).toArray();
    }
}