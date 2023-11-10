package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack();
        Queue<Integer> q = new LinkedList();

        int i=0;
        while(i<nums.length-1 && nums[nums.length-1]>=nums[i]) i++;
        if(i<nums.length-1){
            q.add(i);
            int max = nums[q.peek()];
            i++;
            while(i<nums.length-1){
                if(max < nums[i]){
                    max = nums[i];
                    q.add(i);
                }
                i++;
            }
        }

        for(int j=nums.length-1; j>=0; j--){
            while(st.size()>0 && nums[st.peek()]<=nums[j]) st.pop();
            while(q.size()>0 && nums[q.peek()]<=nums[j]) q.poll();
            if(st.size() != 0){
                ans[j] = nums[st.peek()];
            } else if(q.size() != 0){
                ans[j] = nums[q.peek()];
            } else{
                ans[j] = -1;
            }
            st.add(j);
        }

        return ans;
    }
}
