package Medium;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            int k = 1;
            boolean isPos = false;
            boolean isNeg = false;
            if(nums[i]>0) isPos = true;
            else isNeg = true;
            int next = (i+nums[i]) % len;
            if(next<0) next += len;
            while(k<len && next != i){
                if(nums[next]>0) isPos = true;
                else isNeg = true;
                k++;
                int temp = next;
                next = (next+nums[next]) % len;
                if(next<0) next += len;
                if(temp == next){
                    k = 1;
                    break;
                }
            }
            if(k>1 && !(isPos && isNeg)) return true;
        }
        return false;
    }
}
