import java.util.*;

class Solution {
    List<String> wordList = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", 0);
        return wordList.indexOf(word)+1;
    }
    private void dfs (String current, int depth) {
        if (depth > 5) return;
        
        if (!current.equals("")) {
            wordList.add(current);
        }
        for (String v : vowels) {
            dfs(current+v, depth+1);
        }
    }
}