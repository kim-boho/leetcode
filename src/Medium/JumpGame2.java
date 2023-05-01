package Medium;

public class JumpGame2 {
    public int jump(int[] nums) {
        int[] minSteps = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int step = nums[i];
            while(step > 0){
                if(i+step < nums.length){
                    if(minSteps[i+step]==0) minSteps[i+step] = minSteps[i]+1;
                    else minSteps[i+step] = Math.min(minSteps[i+step],minSteps[i]+1);
                }
                step--;
            }
        }

        return minSteps[nums.length-1];
    }
}
