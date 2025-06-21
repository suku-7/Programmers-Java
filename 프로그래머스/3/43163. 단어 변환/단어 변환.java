import java.util.*;

class Solution {
    private class Word {
        String word;
        int step;
        Word (String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Word(begin, 0));
        
        if (!Arrays.asList(words).contains(target)) {
            return 0; 
        }
        
        while (!queue.isEmpty()) {
            Word current = queue.poll();
            
            if (target.equals(current.word)) {
                return current.step;
            }
            
            for (int i=0; i<words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], current.step+1));
                }
            }
        }
        return 0;
    }
    private boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}