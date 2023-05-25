package Hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        // monotonic stack
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        int[] leftClosestLessElements = new int[heights.length];
        int[] rightClosestLessElements = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            if(st.size() == 0){
                leftClosestLessElements[i] = -1;
            } else{
                int idx = st.peek();
                while(st.size()>0 && heights[i]<=heights[idx]) idx = st.pop();
                if(heights[i]>heights[idx]){
                    st.push(idx);
                    leftClosestLessElements[i] = idx;
                }
                else leftClosestLessElements[i] = -1;
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=heights.length-1; i>=0; i--){
            if(st.size() == 0){
                rightClosestLessElements[i] = -1;
            } else{
                int idx = st.pop();
                while(st.size()>0 && heights[i]<=heights[idx]) idx = st.pop();
                if(heights[i]>heights[idx]){
                    st.push(idx);
                    rightClosestLessElements[i] = idx;
                }
                else rightClosestLessElements[i] = -1;
            }
            st.push(i);
        }

        for(int i=0; i<heights.length; i++){
            int tempMaxArea = heights[i];

            if(leftClosestLessElements[i] == -1) tempMaxArea += i*heights[i];
            else tempMaxArea += (i-leftClosestLessElements[i]-1)*heights[i];

            if(rightClosestLessElements[i] == -1) tempMaxArea += (heights.length-i-1)*heights[i];
            else tempMaxArea += (rightClosestLessElements[i]-i-1)*heights[i];
            maxArea = Math.max(maxArea, tempMaxArea);

        }
        return maxArea;
    }
}
