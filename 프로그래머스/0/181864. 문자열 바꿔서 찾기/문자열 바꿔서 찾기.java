class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : myString.toCharArray()) {
            if (c == 'A') {
                sb.append("B");
            } else {
                sb.append("A");
            }
        }
        String converted = sb.toString();
        return converted.contains(pat)? 1: 0;
    }
}