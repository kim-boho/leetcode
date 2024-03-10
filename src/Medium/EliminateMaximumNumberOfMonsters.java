package Medium;

public class EliminateMaximumNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int l = dist.length;
        int[] mons = new int[l+1];
        for(int i=0; i<l; i++){
            int c = dist[i]/speed[i];
            if(dist[i] % speed[i] != 0) c++;
            if(c > l) c = l;
            mons[c]++;
        }
        int ans = 0;
        int time = 0;
        for(int i=1; i<=l; i++){
            while(mons[i] > 0){
                if(time < i){
                    ans++;
                    time++;
                    mons[i]--;
                } else break;
            }
            if(mons[i] > 0) break;
        }
        return ans;
    }
}
