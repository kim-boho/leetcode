package Medium;

public class ConstructQuadTree {
    public QuadNode construct(int[][] grid) {
        return helper(grid, 0, grid.length, 0, grid.length);
    }

    private QuadNode helper(int[][] grid, int startRow, int endRow, int startCol, int endCol){
        boolean isLeaf = true;
        int val = grid[startRow][startCol];

        for(int i=startRow; isLeaf && i<endRow; i++){
            for(int j=startCol; isLeaf && j<endCol; j++){
                if(grid[i][j] != val){
                    isLeaf = false;
                }
            }
        }

        if(isLeaf){
            return new QuadNode(val == 0? false:true, isLeaf);
        } else{
            int midRow = (startRow+endRow)/2;
            int midCol = (startCol+endCol)/2;
            QuadNode topLeft = helper(grid, startRow, midRow, startCol, midCol);
            QuadNode topRight = helper(grid, startRow, midRow, midCol, endCol);
            QuadNode bottomLeft = helper(grid, midRow, endRow, startCol, midCol);
            QuadNode bottomRight = helper(grid, midRow, endRow, midCol, endCol);
            return new QuadNode(true, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}

class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;


    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};