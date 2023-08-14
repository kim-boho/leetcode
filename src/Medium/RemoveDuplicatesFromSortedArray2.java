package Medium;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int prev = nums[0];
        int count = 1;
        int position = 0;
        for(int i=1; i<n; i++){
            if(prev != nums[i]){
                if(count > 1){
                    ans += 2;
                    nums[position++] = prev;
                    nums[position++] = prev;
                    count = 1;
                }
                else{
                    ans++;
                    if(position<n) nums[position++] = prev;
                }
                prev = nums[i];
            } else count++;
        }

        if(count>1){
            ans += 2;
            nums[position++] = prev;
            nums[position] = prev;
        } else{
            ans++;
            nums[position++] = prev;
        }

        return ans;
    }
}
