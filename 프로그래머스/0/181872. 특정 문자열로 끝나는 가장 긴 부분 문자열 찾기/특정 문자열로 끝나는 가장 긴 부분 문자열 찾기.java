class Solution {
    public String solution(String myString, String pat) {
        int lastindex = myString.lastIndexOf(pat);
        return myString.substring(0, lastindex+pat.length());
    }
}