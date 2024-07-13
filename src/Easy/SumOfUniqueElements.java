package Easy;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        int[] sum = new int[101];
        int ans = 0;
        for(int n:nums){
            if(sum[n] == 0){
                sum[n] = n;
                ans += n;
            } else if(sum[n] == n){
                sum[n] = -1;
                ans -= n;
            }
        }
        return ans;
    }
}
