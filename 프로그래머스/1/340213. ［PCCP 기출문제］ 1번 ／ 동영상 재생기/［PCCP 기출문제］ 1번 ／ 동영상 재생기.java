import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = toSecond(video_len);
        int curSec = toSecond(pos);
        int opStartSec = toSecond(op_start);
        int opEndSec = toSecond(op_end);
        
        if (curSec >= opStartSec && curSec <= opEndSec) {
            curSec = opEndSec;
        }
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                curSec = Math.max(0, curSec - 10);
            } else if (cmd.equals("next")) {
                curSec = Math.min(videoSec, curSec+10);
            }
            
            if (curSec >= opStartSec && curSec <= opEndSec) {
                curSec = opEndSec;
            }
        }
        return toTime(curSec);
    }
    private int toSecond(String time) {
        String[] parts = time.split(":");
        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        return minute * 60 + second;
    }
    private String toTime(int totalSeconds) {
        int minute = totalSeconds / 60;
        int second = totalSeconds % 60;
        return String.format("%02d:%02d", minute, second);
    }
}