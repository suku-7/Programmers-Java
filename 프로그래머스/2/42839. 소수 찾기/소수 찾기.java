import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs("", numbers, 0);
        
        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            } 
        }
        return count;
    }
    private void dfs(String current, String numbers, int depth) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }
        for (int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current+numbers.charAt(i), numbers, depth+1);
                visited[i] = false;
            }
        }
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i=2; i<=sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}