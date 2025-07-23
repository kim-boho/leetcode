package Hard;

public class NumberOfVisiblePeopleInAQueue {
    public int[] canSeePersonsCount(int[] heights) {
        int[] stack = new int[heights.length];
        int p = 0;
        int[] ans = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            int h = heights[i];
            if(p == 0) stack[p++] = i;
            else{
                int prev = stack[p-1];
                if(heights[prev] > h) {
                    ans[prev]++;
                    stack[p++] = i;
                } else{
                    while(p != 0 && heights[stack[p-1]] < h){
                        ans[stack[p-1]]++;
                        p--;
                    }
                    if(p != 0) ans[stack[p-1]]++;
                    stack[p++] = i;
                }
            }
        }
        return ans;
    }
}
