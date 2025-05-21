class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // Case 1: 첫 번째 집을 포함하고 마지막 집을 제외
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        // Case 2: 첫 번째 집을 제외하고 마지막 집을 포함
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        for (int i=2; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}