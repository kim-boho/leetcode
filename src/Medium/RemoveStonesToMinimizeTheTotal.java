package Medium;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        int[] stones = new int[10001];
        for(int n:piles) stones[n]++;
        for(int i=10000; i>0 && k>0; i--){
            while(k > 0 && stones[i] != 0){
                stones[i]--;
                k--;
                stones[i-i/2]++;
            }
        }
        int ans = 0;
        for(int i=0; i<stones.length; i++){
            ans += (i*stones[i]);
        }
        return ans;
    }
}
