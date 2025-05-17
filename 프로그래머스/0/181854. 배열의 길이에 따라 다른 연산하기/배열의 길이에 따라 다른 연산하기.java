class Solution {
    public int[] solution(int[] arr, int n) {
        int arrLen = arr.length;
        int[] answer = new int[arrLen];
        
        for (int i=0; i<arrLen; i++) {
            if ((arrLen %2 == 1) && (i % 2 == 0)) {
                answer[i] = arr[i] + n;
            } else if ((arrLen %2 == 0) && (i % 2 == 1)) {
                answer[i] = arr[i] + n;
            } else {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}