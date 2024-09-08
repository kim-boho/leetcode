package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        HashMap<Integer, HashSet<Integer>> xObs = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yObs = new HashMap<>();
        for(int[] ob:obstacles){
            if(!xObs.containsKey(ob[0])) xObs.put(ob[0], new HashSet<>());
            xObs.get(ob[0]).add(ob[1]);
            if(!yObs.containsKey(ob[1])) yObs.put(ob[1], new HashSet<>());
            yObs.get(ob[1]).add(ob[0]);
        }
        int dir = 0;
        int x = 0;
        int y = 0;
        for(int c:commands){
            if(c < 1){
                if(c == -1){
                    dir++;
                    dir %= 4;
                } else{
                    dir--;
                    if(dir == -1) dir = 3;
                }
            } else{
                HashSet<Integer> checkCoors;
                int i = 1;
                int add = 1;
                int target;
                if(dir == 0 || dir == 2){
                    target = y;
                    checkCoors = xObs.get(x);
                    if(dir == 2){
                        i = -1;
                        add = -1;
                    }
                } else{
                    target = x;
                    checkCoors = yObs.get(y);
                    if(dir == 3){
                        i = -1;
                        add = -1;
                    }
                }
                if(checkCoors == null){
                    if(dir == 0) y += c;
                    else if(dir == 2) y -= c;
                    else if(dir == 1) x += c;
                    else x -= c;
                }
                int temp = c;
                while(checkCoors != null && temp > 0){
                    if(checkCoors.contains(target+i)){
                        target += i;
                        if(dir <= 1) target--;
                        else target++;
                        if(dir == 0 || dir == 2) y = target;
                        else x = target;
                        break;
                    } else{
                        i += add;
                    }
                    temp--;
                }
                if(temp == 0){
                    if(dir == 0) y += c;
                    else if(dir == 2) y -= c;
                    else if(dir == 1) x += c;
                    else x -= c;
                }
            }
            ans = Math.max(ans,x*x+y*y);
        }
        return ans;
    }
}
