class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String prefix = my_string.substring(0, s);
        String suffix = my_string.substring(s + overwrite_string.length());
        answer = prefix + overwrite_string + suffix;
        return answer;
    }
}