import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
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
    private void permutation(String current, String remain) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }
        for (int i=0; i<remain.length(); i++) {
            permutation(current+remain.charAt(i), remain.substring(0, i)+remain.substring(i+1));
        }
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i=2; i<=sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
} 