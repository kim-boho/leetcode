package Medium;

public class MaxConsecutiveOnes2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prevOnes = 0;
        int i = 0;
        int ans = 0;
        while(i < nums.length){
            int zeros = 0;
            while(i < nums.length && nums[i] == 0){
                zeros++;
                i++;
            }
            int ones = 0;
            while(i < nums.length && nums[i] == 1){
                ones++;
                i++;
            }
            if(zeros == 1){
                ans = Math.max(ans,prevOnes+ones+1);
            } else if(zeros > 1){
                ans = Math.max(Math.max(prevOnes,ones)+1,ans);
            }  else{
                ans = Math.max(ans,Math.max(prevOnes,ones));
            }
            prevOnes = ones;
        }
        return ans;
    }
}
