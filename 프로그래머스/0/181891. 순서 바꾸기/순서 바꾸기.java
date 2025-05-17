import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] back = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] front = Arrays.copyOfRange(num_list, 0, n);
        
        int[] result = new int[num_list.length];
        System.arraycopy(back, 0, result, 0, back.length);
        System.arraycopy(front, 0, result, back.length, front.length);
        
        return result;
    } 
}