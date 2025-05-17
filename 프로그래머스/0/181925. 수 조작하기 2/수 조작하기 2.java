class Solution {
    public String solution(int[] numLog) {
        StringBuilder result = new StringBuilder();
        
        for (int i=1; i<numLog.length; i++) {
            int diff = numLog[i] - numLog[i-1];
            if (diff == 1) {
                result.append("w");
            } else if (diff == -1) {
                result.append("s");
            } else if (diff == 10) {
                result.append("d"); 
            } else if (diff == -10) {
                result.append("a");
            }
        }
        return result.toString();
    }
}