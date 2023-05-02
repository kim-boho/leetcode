package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame4 {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] reached = new boolean[s.length()];
        q.add(0);
        while(q.size()>0){
            int idx = q.poll();
            if(!reached[idx]){
                for(int k=idx; k<s.length(); k++){
                    if(s.charAt(k) == '0'){
                        int j = k;
                        int i = j-minJump;
                        while(!(i+minJump<=j && j<=Math.min(i+maxJump, s.length()-1))){
                            i--;
                        }
                        while(i<=j){
                            if(idx+i == s.length()-1) return true;
                            q.add(idx+i++);
                        }
                    }
                }
            }
            reached[idx] = true;
        }
        return false;
    }
}
