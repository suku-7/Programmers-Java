class Solution {
    public String solution(String my_string, int k) {
        StringBuilder result = new StringBuilder();
        
        for (int i=1; i<k+1; i++) {
            result.append(my_string);
        }
        return result.toString();
    }
}