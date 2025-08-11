package Hard;

public class SmallestRectangleEnclosingBlackPixels {
    int minX;
    int minY;
    int maxX;
    int maxY;
    public int minArea(char[][] image, int x, int y) {
        minX = x;
        maxX = x;
        minY = y;
        maxY = y;
        boolean[][] checkedPixels = new boolean[image.length][image[0].length];
        dfs(image,checkedPixels,x,y);
        return (maxX-minX+1)*(maxY-minY+1);
    }

    private void dfs(char[][] image, boolean[][] checkedPixels, int x, int y){
        if(x < 0 || y < 0 || x >= checkedPixels.length || y >= checkedPixels[0].length
                || checkedPixels[x][y] || image[x][y] == '0') return;
        minX = Math.min(x,minX);
        maxX = Math.max(x,maxX);
        minY = Math.min(y,minY);
        maxY = Math.max(y,maxY);
        checkedPixels[x][y] = true;
        dfs(image,checkedPixels,x-1,y);
        dfs(image,checkedPixels,x+1,y);
        dfs(image,checkedPixels,x,y-1);
        dfs(image,checkedPixels,x,y+1);
    }
}
