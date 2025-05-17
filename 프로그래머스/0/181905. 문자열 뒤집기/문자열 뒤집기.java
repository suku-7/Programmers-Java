class Solution {
    public String solution(String my_string, int s, int e) {
        String prefix = my_string.substring(0, s);
        String reversed = new StringBuilder(my_string.substring(s, e+1)).reverse().toString(); 
        String suffix = my_string.substring(e+1);
        return prefix + reversed + suffix;
    }
}