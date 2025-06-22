import java.util.*;
class Solution {
    List<String> answer = new ArrayList<>();
    boolean[] visited;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        int n = tickets.length;
        visited = new boolean[n];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", tickets, path, 0);
        
        return answer.toArray(new String[0]);
    }
    private void dfs(String current, String[][] tickets, List<String> path, int count) {
        if (found) return;
        if (tickets.length == count) {
            answer = new ArrayList<>(path);
            found = true;
            return;
        }
        for (int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, path, count+1);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}