package Easy;

public class AndOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int dis = 0;
        int ans = 0;
        for(int n:nums){
            dis += n;
            if(dis == 0) ans++;
        }
        return ans;
    }
}
