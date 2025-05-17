class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(my_string.substring(my_string.length() - n));
        return sb.toString();
    }
}