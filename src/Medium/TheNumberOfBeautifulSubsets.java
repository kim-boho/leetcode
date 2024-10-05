package Medium;

import java.util.ArrayList;

public class TheNumberOfBeautifulSubsets {
    int ans = 0;
    public int beautifulSubsets(int[] nums, int k) {
        ArrayList<Integer> li = new ArrayList<>();
        int[] blocks = new int[1001];
        recursion(li,0,nums,k,blocks);
        return ans;
    }

    private void recursion(ArrayList<Integer> li, int idx, int[] nums, int k, int[] blocks){
        if(idx == nums.length) return;
        int n = nums[idx];
        if(blocks[n]==0){
            li.add(n);
            if(n-k > 0) blocks[n-k]++;
            if(n+k < 1001) blocks[n+k]++;
            ans++;
            recursion(li,idx+1,nums,k,blocks);
            li.remove(li.size()-1);
            if(n-k > 0) blocks[n-k]--;
            if(n+k < 1001) blocks[n+k]--;
        }
        recursion(li,idx+1,nums,k,blocks);
    }
}
