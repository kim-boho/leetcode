package Easy;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        boolean[] checked = new boolean[nums.length];
        int[] ans = new int[2];
        for(int n:nums){
            if(!checked[n-1]) checked[n-1] = true;
            else ans[0] = n;
        }
        for(int i=0; i<checked.length; i++){
            if(!checked[i]) ans[1] = i+1;
        }
        return ans;
    }
}
