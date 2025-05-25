import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        // 모든 전화번호를 HashSet에 저장
        for (String phone : phone_book) {
            set.add(phone);
        }

        // 각 전화번호에 대해 접두어가 HashSet에 있는지 확인
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (set.contains(prefix)) {
                    return false; // 접두어가 있으면 false 반환
                }
            }
        }

        return true;
    }
}