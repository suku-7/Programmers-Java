import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pokemons = new HashSet<>();
        
        for (int num : nums) {
            pokemons.add(num);
        }
        int maxP = Math.min(pokemons.size(), nums.length/2);
        return maxP;
    }
}