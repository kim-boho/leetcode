package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf4 {
    public static void main(String[] args) {
        SumOf4 obj = new SumOf4();
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> li = obj.fourSum(nums, -294967296);
        for(int i=0; i<li.size(); i++){
            for(int j=0; j<li.get(i).size(); j++){
                System.out.print(li.get(i).get(j)+",");
            }
            System.out.println("");
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            while(i<nums.length-3 && i>0 && nums[i-1] == nums[i]) i++;
            for(int j=nums.length-1; j>i+2; j--){
                while(j>=0 && j<nums.length-1 && nums[j+1] == nums[j]) j--;
                int left = i+1;
                int right = j-1;
                while(left<right){
                    long sum = (long)nums[left]+(long)nums[right]+(long)nums[i]+(long)nums[j];
                    if(sum == target){
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);li.add(nums[left]);li.add(nums[right]);li.add(nums[j]);
                        ans.add(li);
                        left++;
                        right--;
                        while(left<nums.length && nums[left-1] == nums[left]) left++;
                        while(right>=0 && nums[right+1] == nums[right]) right--;
                    } else if(sum > target){
                        right--;
                    } else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
