package Easy;

import java.util.Arrays;

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int[] arr = new int[101];
        Arrays.fill(arr,-1);
        for(int i=0; i<nums.length; i++){
            if(arr[nums[i]] == -1){
                arr[nums[i]] = i;
            } else{
                arr[nums[i]] = -2;
            }
        }
        boolean isMax = false;
        int max = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == -1) continue;
            else if(arr[i] == -2){
                if(isMax){
                    if(max >= i*2) return arr[max];
                    else return -1;
                } else return -1;
            } else{
                if(!isMax){
                    isMax = true;
                    max = i;
                } else{
                    if(max >= i*2) return arr[max];
                    else return -1;
                }
            }
        }
        return -1;
    }
}
