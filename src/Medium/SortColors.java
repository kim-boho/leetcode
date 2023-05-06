package Medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int idx = 0;
        for(int i=0; i<2; i++){
            int tempIdx = idx;
            while(idx < nums.length){
                if(nums[idx]==i){
                    int tempColor = nums[tempIdx];
                    nums[tempIdx] = i;
                    nums[idx] = tempColor;
                    tempIdx++;
                }
                idx++;
            }
            idx = tempIdx;
        }
        return;
    }
}
