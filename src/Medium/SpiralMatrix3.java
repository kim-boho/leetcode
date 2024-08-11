package Medium;

public class SpiralMatrix3 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows*cols][2];
        int count = 1;
        int maxNum = rows*cols;
        int num = 0;
        int r = rStart;
        int c = cStart;
        while(num < maxNum){
            for(int i=0; i<count; i++){
                if(num < maxNum && r>=0 && r<rows && c<cols && c>=0){
                    ans[num][0] = r;
                    ans[num++][1] = c;
                }
                c++;
            }
            for(int i=0; i<count; i++){
                if(num < maxNum && c>=0 && c<cols && r<rows && r>=0){
                    ans[num][0] = r;
                    ans[num++][1] = c;
                }
                r++;
            }
            count++;
            for(int i=0; i<count; i++){
                if(num < maxNum && r>=0 && r<rows && c>=0 && c<cols){
                    ans[num][0] = r;
                    ans[num++][1] = c;
                }
                c--;
            }
            for(int i=0; i<count; i++){
                if(num < maxNum && c>=0 && c<cols && r>=0 && r<rows){
                    ans[num][0] = r;
                    ans[num++][1] = c;
                }
                r--;
            }
            count++;
        }
        return ans;
    }
}
