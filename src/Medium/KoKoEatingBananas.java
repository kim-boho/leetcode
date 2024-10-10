package Medium;

public class KoKoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while(left <= right){
            int mid = (right-left)/2+left;
            if(getHours(piles,mid) > h) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    private long getHours(int[] piles, int num){
        long ans = 0;
        for(int n:piles){
            ans += n/num;
            if(n % num != 0) ans++;
        }
        return ans;
    }
}
