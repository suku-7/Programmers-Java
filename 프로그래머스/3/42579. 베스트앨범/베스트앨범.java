import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> gSum = new HashMap<>();
        Map<String, List<int[]>> gMap = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            gSum.put(genres[i], gSum.getOrDefault(genres[i], 0)+plays[i]);
            
            if (!gMap.containsKey(genres[i])) {
                gMap.put(genres[i], new ArrayList<>());
            }
            gMap.get(genres[i]).add(new int[]{i, plays[i]});
        }
        List<String> gList = new ArrayList<>(gSum.keySet());
        gList.sort((a, b) -> gSum.get(b) - gSum.get(a));
        
        List<Integer> res = new ArrayList<>();
        
        for (String genre : gList) {
            List<int[]> list = gMap.get(genre);
            
            list.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);
            res.add(list.get(0)[0]);
            
            if (list.size() > 1) {
                res.add(list.get(1)[0]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}