import java.util.*;


class Solution {
    List<String> answer = new ArrayList<>();
    boolean[] used;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        used = new boolean[n];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", tickets, path, 0);
        
        return answer.toArray(new String[0]);
    }
    private void dfs(String current, String[][] tickets, List<String> path, int count) {
        if (found) return;
        
        if (count == tickets.length) {
            answer = new ArrayList<>(path);
            found = true;
            return;
        }
        for (int i=0; i<tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, path, count+1);
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }
}