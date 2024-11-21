package Easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        dfs(image,sr,sc,color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color){
        int origin = image[r][c];
        image[r][c] = color;
        if(r-1 >= 0 && image[r-1][c] == origin) dfs(image, r-1, c, color);
        if(r+1 < image.length && image[r+1][c] == origin) dfs(image, r+1, c, color);
        if(c-1 >= 0 && image[r][c-1] == origin) dfs(image, r, c-1, color);
        if(c+1 < image[0].length && image[r][c+1] == origin) dfs(image, r, c+1, color);
    }
}
