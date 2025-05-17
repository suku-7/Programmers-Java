class Solution {
    public int[] solution(String my_string) {
        int[] count = new int[52];
        
        for (int i=0; i<my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            if ('A' <= ch && ch <= 'Z') {
                count[ch - 'A']++;
            } else if ('a' <= ch && ch <= 'z') {
                count[ch - 'a' + 26]++;
            }
        }
        return count;
    }
}