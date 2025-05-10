package Easy;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int max = 45;
        int maxLen = 0;
        int[] counts = new int[max+1];
        for(int i=1; i<=n; i++){
            int j=i;
            int sum=0;
            while(j > 0){
                sum += j%10;
                j /= 10;
            }
            counts[sum]++;
            maxLen = Math.max(counts[sum],maxLen);
        }
        int ans = 0;
        for(int i:counts){
            if(i == maxLen) ans++;
        }
        return ans;
    }
}
