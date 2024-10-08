package Medium;

public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int maxW) {
        int n = books.length;
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++){
            int w = books[i-1][0];
            int h = books[i-1][1];
            dp[i] = dp[i-1]+h;
            for(int j=i-1; j>0; --j){
                w += books[j-1][0];
                if(w > maxW) break;
                h = Math.max(h,books[j-1][1]);
                dp[i] = Math.min(dp[i],dp[j-1]+h);
            }
        }
        return dp[n];
    }
}
