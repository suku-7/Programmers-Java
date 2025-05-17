class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        
        for (int i=0; i<num_list.length; i++) {
            if (i % 2 == 0) {
                odd += num_list[i];
            } else {
                even += num_list[i];
            }
        }
        
        if (odd >= even) {
            return odd;
        } else {
            return even;
        }
    }
}