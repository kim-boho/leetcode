package Medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0;
        int leftWall = 0;
        int rightWall = height.length-1;
        int minHeight = Math.min(height[leftWall], height[rightWall]);
        while(leftWall<rightWall){
            int temp = minHeight * (rightWall-leftWall);
            if(temp>ans) ans = temp;
            if(height[leftWall]<height[rightWall]){
                leftWall++;
            } else{
                rightWall--;
            }
            minHeight = Math.min(height[leftWall], height[rightWall]);
        }

        return ans;
    }
}
