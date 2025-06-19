import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);
        HashSet<Integer> realLost = new HashSet<>(lostSet);
        
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l);
                realLost.remove(l);
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