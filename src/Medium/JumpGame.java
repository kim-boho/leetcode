package Medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length != 1 && nums[0] == 0) return false;
        if(nums.length == 1) return true;

        boolean[] reached = new boolean[nums.length];
        reached[0] = true;
        for(int i=0; i<nums.length; i++){
            if(reached[i]){
                int steps = nums[i];
                while(steps > 0){
                    if(steps+i<nums.length){
                        reached[i+steps] = true;
                        if(reached[nums.length-1]) return true;
                    }
                    steps--;
                }
            }
        }
        return false;
    }
}
