import java.util.*;

class Solution {
    public String solution(String s) {
        return s.chars() // 문자열을 IntStream으로 변환 (각 문자 → 유니코드 정수)
                .boxed() // IntStream → Stream<Integer> (박싱)
                .sorted((v1, v2) -> v2 - v1) // 내림차순 정렬
                .collect(StringBuilder::new, // StringBuilder를 초기값으로 생성
                         StringBuilder::appendCodePoint, // 유니코드 값 → 문자 추가
                         StringBuilder::append) // 병렬 처리 시 사용하는 병합기 (병합 로직)
                .toString(); // 최종 문자열로 변환
    }
}