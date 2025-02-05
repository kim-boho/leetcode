package Easy;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int len1 = img.length;
        int len2 = img[0].length;
        int[][] ans = new int[len1][len2];
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                int sum = 0;
                int count = 0;
                for(int m=Math.max(0,i-1); m<=Math.min(len1-1,i+1); m++){
                    for(int n=Math.max(0,j-1); n<=Math.min(len2-1,j+1); n++){
                        sum += img[m][n];
                        count++;
                    }
                }
                ans[i][j] = sum/count;
            }
        }
        return ans;
    }
}
