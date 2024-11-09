package Medium;

import java.util.HashSet;

public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int celeb = 0;
        for(int i=1; i<n; i++){
            if(knows(celeb,i)) celeb = i;
        }
        for(int i=0; i<n; i++){
            if(celeb != i && (knows(celeb,i) || !knows(i,celeb))) return -1;
        }
        return celeb;
    }
    public int findCelebrity2(int n) {
        HashSet<Integer> candidates = new HashSet<>();
        candidates.add(0);
        for(int i=1; i<n; i++){
            if(knows(0,i)) candidates.add(i);
        }
        for(int i=1; i<n; i++){
            HashSet<Integer> temp = new HashSet<>();
            for(int m:candidates){
                if(knows(i,m)) temp.add(m);
            }
            if(temp.isEmpty()) return -1;
            candidates = temp;
        }
        if(candidates.size() != 1) return -1;
        int ans = 0;
        for(int m:candidates){
            ans = m;
            for(int i=0; i<n; i++){
                if(i != m && knows(m,i)) return -1;
            }
        }
        return ans;
    }
    boolean knows(int a, int b){
        return true;
    }
}