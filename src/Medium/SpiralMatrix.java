package Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> li = obj.spiralOrder(matrix);
        for(int i:li){
            System.out.println(i);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while(left<=right && top<=bottom){
            for(int i=left; i<=right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            if(top > bottom) break;
            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(left > right) break;
            for(int i=right; i>=left; i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom) break;
            for(int i=bottom; i>=top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
            if(left > right) break;
        }

        return ans;
    }
}
