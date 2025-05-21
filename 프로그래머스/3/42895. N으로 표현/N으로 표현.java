import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        //0번은 사용하지 않음, index 1~8까지 사용
        for (int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }
        // N을 i번 이어붙이 ㄴ숫자 추가 (예: 5, 55, 555..)
        for (int i=1; i<=8; i++) {
            int nn = 0;
            for (int j=0; j<i; j++) {
                nn = nn * 10 + N;
            }
            dp.get(i).add(nn);
        }
        // DP 구성
        for (int i=1; i<=8; i++) {
            // i를 j와 (i-j)로 나누는 모든 경우
            for (int j=1; j<i; j++) {
                for (int a: dp.get(j)) {
                    for (int b : dp.get(i-j)) {
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if (b != 0) dp.get(i).add(a/b);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}