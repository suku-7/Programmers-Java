import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int n = rank.length;
        
        List<int[]> students = new ArrayList<>();
        for (int i=0; i<n; i++) {
            students.add(new int[]{rank[i], i});
        }
        students.sort(Comparator.comparingInt(a -> a[0]));
        
        int[] selected = new int[3];
        int count = 0;
        for (int[] student : students) {
            if (attendance[student[1]]) {
                selected[count] = student[1];
                count++;
                if (count==3) {
                    break;
                }
            }
        }
        int a = selected[0];
        int b = selected[1];
        int c = selected[2];
        
        return 10000 * a + 100 * b + c;
    }
}