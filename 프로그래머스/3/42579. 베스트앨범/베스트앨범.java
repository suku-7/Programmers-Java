import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayMap = new HashMap<>();
        Map<String, List<int[]>> genreToSongs = new HashMap<>();
        
        // 1. 장르별 총 재생 수, 장르별 노래 목록 저장
        for (int i=0; i<genres.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
            genreToSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        // 2. 장르를 총 재생 수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayMap.keySet());
        sortedGenres.sort((a, b) -> genrePlayMap.get(b) - genrePlayMap.get(a));
        
        // 3. 각 장르별 노래를 재생 수 기준으로 정렬하고 최대 2개씩 수록
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);
            songs.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return a[0] - b[0];
            });
            for (int i=0; i<Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            } 
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}