class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            
            maxW = Math.max(w, maxW);
            maxH = Math.max(h, maxH);
        }
        return maxW * maxH;
    }
}