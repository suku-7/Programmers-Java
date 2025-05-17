import java.util.ArrayList;

class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> result = new ArrayList<>();
        
        for (int i=0; i<names.length; i+=5) {
            result.add(names[i]);
        }
        String[] answer = new String[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}