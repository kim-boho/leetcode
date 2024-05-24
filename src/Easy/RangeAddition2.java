package Easy;

public class RangeAddition2 {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;
        for(int[] arr:ops){
            int x = arr[0];
            int y = arr[1];
            if(x<minX) minX = x;
            if(y<minY) minY = y;
        }
        return minX*minY;
    }
}
