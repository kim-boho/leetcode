package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> seen = new HashSet<>(Arrays.asList(deadends));
        if(seen.contains("0000")) return -1;
        if(target.equals("0000")) return 0;

        int ans = 0;
        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int j=0; j<size; j++){
                StringBuilder sb = new StringBuilder(q.poll());
                for(int i=0; i<4; i++){
                    char temp = sb.charAt(i);
                    sb.setCharAt(i,temp == '9'? '0':(char) (temp+1));
                    String next = sb.toString();
                    if(next.equals(target)) return ans;
                    if(!seen.contains(next)){
                        seen.add(next);
                        q.offer(next);
                    }
                    sb.setCharAt(i,temp == '0'? '9':(char) (temp-1));
                    next = sb.toString();
                    if(next.equals(target)) return ans;
                    if(!seen.contains(next)){
                        seen.add(next);
                        q.offer(next);
                    }
                    sb.setCharAt(i,temp);
                }
            }
        }
        return -1;
    }
}
