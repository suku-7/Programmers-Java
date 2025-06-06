import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        permutation("", numbers);
        
        int count = 0;
        
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }
    public void permutation(String prefix, String remain) {
        if (!prefix.equals("")) {
            numberSet.add(Integer.parseInt(prefix));
        }
        for (int i=0; i<remain.length(); i++) {
            permutation(prefix+remain.charAt(i), remain.substring(0,i)+remain.substring(i+1));
        }
    }
    public boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i=2; i<=sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}