import java.util.*;

class Solution {
    // 큐에 넣을 단어와 단계
    private class Word {
        String word;
        int step;
        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int solution(String begin, String target, String[] words) {
        // target이 words에 없다면 반환 불가
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Word(begin, 0)); // 시작 단어와 단계 0부터 시작

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            // target 도달 시 정답 반환
            if (current.word.equals(target)) {
                return current.step;
            }
            // 다음 단어 탐색
            for (int i=0; i<words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], current.step+1));
                }
            }
        }
        // 변환 불가능한 경우
        return 0;
    }
    private boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}