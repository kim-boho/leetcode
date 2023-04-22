package Hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length < 3) return 0;

        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int [height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for(int i=1; i<height.length; i++){
            if(leftMax[i-1]>height[i]) leftMax[i] = leftMax[i-1];
            else leftMax[i] = height[i];
        }

        for(int i=height.length-2; i>=0; i--){
            if(rightMax[i+1]>height[i]) rightMax[i] = rightMax[i+1];
            else rightMax[i] = height[i];
        }

        for(int i=1; i<height.length-1; i++){
            if(Math.min(leftMax[i-1], rightMax[i+1])>height[i]) ans += Math.min(leftMax[i-1], rightMax[i+1]) - height[i];
        }

        return ans;
    }
}
