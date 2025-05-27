import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // HashSet을 이용해 중복 없는 포켓몬 종류를 저장
        HashSet<Integer> set = new HashSet<>();
        
        // 입력된 nums 배열의 각 숫자를 HashSet에 추가
        for (int num : nums) {
            set.add(num); // 중복된 값은 자동으로 제거됨
        }
        
        // 선택할 수 있는 포켓몬 수는 전체의 절반 (nums.length / 2)
        // 중복을 제거한 포켓몬 종류 수(set.size())와 비교하여 더 작은 값을 반환
        return Math.min(set.size(), nums.length / 2);
    }
}