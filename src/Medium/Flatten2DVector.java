package Medium;

public class Flatten2DVector {
    int[][] vec;
    int row;
    int col;
    public Flatten2DVector(int[][] vec) {
        this.vec = vec;
        row = 0;
        col = 0;
    }

    public int next() {
        int ans = vec[row][col];
        if(vec[row].length-1 == col){
            col = 0;
            row++;
        } else col++;
        return ans;
    }

    public boolean hasNext() {
        while(row < vec.length && vec[row].length == 0) row++;
        return row < vec.length;
    }
}
