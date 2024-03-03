package Easy;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        if(nums[0]>=0 && nums[n-1]>=0){
            for(int i=0; i<nums.length; i++){
                ans[i] = nums[i]*nums[i];
            }
        } else if(nums[0]<=0 && nums[n-1]<=0){
            for(int i=0; i<nums.length; i++){
                ans[i] = nums[n-1-i]*nums[n-1-i];
            }
        } else{
            int mid = 1;
            while(mid < n && !(nums[mid] == 0 || (nums[mid-1]<0 && nums[mid]>0))) mid++;
            int left = mid-1;
            int right = mid;
            int count = 0;
            while(left>=0 || right<n){
                if(left<0){
                    ans[count] = nums[right]*nums[right];
                    right++;
                } else if(right>=n){
                    ans[count] = nums[left]*nums[left];
                    left--;
                } else{
                    if(Math.abs(nums[left])>Math.abs(nums[right])){
                        ans[count] = nums[right]*nums[right];
                        right++;
                    } else{
                        ans[count] = nums[left]*nums[left];
                        left--;
                    }
                }
                count++;
            }
        }
        return ans;
    }
}
