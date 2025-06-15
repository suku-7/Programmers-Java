import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);
        
        Set<Integer> realLost = new HashSet<>(lostSet);
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                realLost.remove(l);
                reserveSet.remove(l);
            }
        }
        for (int r : reserveSet) {
            if (realLost.contains(r-1)) {
                realLost.remove(r-1);
            } else if (realLost.contains(r+1)) {
                realLost.remove(r+1);
            }
        }
        return n - realLost.size();
    }
}