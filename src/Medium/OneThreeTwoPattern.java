package Medium;

import java.util.Stack;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        int[] minArr = new int[nums.length];
        minArr[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            minArr[i] = Math.min(nums[i], minArr[i-1]);
        }

        Stack<Integer> st = new Stack();
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]>minArr[i]){
                while(st.size()>0 && st.peek()<=minArr[i]){
                    st.pop();
                }
                if(st.size()>0 && st.peek()<nums[i]) return true;
                st.add(nums[i]);
            }
        }
        return false;
    }
}
