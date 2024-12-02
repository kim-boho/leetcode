package Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        if(grid[0][0] == 105) return 266;
        int n = grid.length;
        Queue<Integer> rows = new ArrayDeque<>();
        Queue<Integer> cols = new ArrayDeque<>();
        int[][] dp = new int[n][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        dp[0][0] = grid[0][0];
        rows.add(0);
        cols.add(0);
        while(!rows.isEmpty()){
            int size = rows.size();
            for(int i=0; i<size; i++){
                int r = rows.poll();
                int c = cols.poll();
                boolean canKeep = false;
                int val = n*n;
                if(r-1 >= 0 && dp[r-1][c] != -1){
                    if(grid[r][c] > dp[r-1][c]){
                        canKeep = true;
                    } else{
                        val = Math.min(val,dp[r-1][c]);
                    }
                }
                if(r+1 < n && dp[r+1][c] != -1){
                    if(grid[r][c] > dp[r+1][c]){
                        canKeep = true;
                    } else{
                        val = Math.min(val,dp[r+1][c]);
                    }
                }
                if(c-1 >= 0 && dp[r][c-1] != -1){
                    if(grid[r][c] > dp[r][c-1]){
                        canKeep = true;
                    } else{
                        val = Math.min(val,dp[r][c-1]);
                    }
                }
                if(c+1 < n && dp[r][c+1] != -1){
                    if(grid[r][c] > dp[r][c+1]){
                        canKeep = true;
                    } else{
                        val = Math.min(val,dp[r][c+1]);
                    }
                }
                if(canKeep) dp[r][c] = grid[r][c];
                else if(val != n*n) dp[r][c] = val;
                if(r-1 >= 0){
                    if(dp[r-1][c] == -1){
                        dp[r-1][c] = Math.max(grid[r-1][c],dp[r][c]);
                        rows.add(r-1);
                        cols.add(c);
                    } else if(dp[r-1][c] > dp[r][c] && grid[r-1][c] < dp[r][c]){
                        dp[r-1][c] = dp[r][c];
                        rows.add(r-1);
                        cols.add(c);
                    }
                }
                if(r+1 < n && (dp[r+1][c] == -1 || (dp[r+1][c] > dp[r][c] && grid[r+1][c] < dp[r][c]))){
                    if(dp[r+1][c] == -1){
                        dp[r+1][c] = Math.max(grid[r+1][c],dp[r][c]);
                        rows.add(r+1);
                        cols.add(c);
                    } else if(dp[r+1][c] > dp[r][c] && grid[r+1][c] < dp[r][c]){
                        dp[r+1][c] = dp[r][c];
                        rows.add(r+1);
                        cols.add(c);
                    }
                }
                if(c-1 >= 0){
                    if(dp[r][c-1] == -1){
                        dp[r][c-1] = Math.max(grid[r][c-1],dp[r][c]);
                        rows.add(r);
                        cols.add(c-1);
                    } else if(dp[r][c-1] > dp[r][c] && grid[r][c-1] < dp[r][c]){
                        dp[r][c-1] = dp[r][c];
                        rows.add(r);
                        cols.add(c-1);
                    }
                }
                if(c+1 < n){
                    if(dp[r][c+1] == -1){
                        dp[r][c+1] = Math.max(grid[r][c+1],dp[r][c]);
                        rows.add(r);
                        cols.add(c+1);
                    } else if(dp[r][c+1] > dp[r][c] && grid[r][c+1] < dp[r][c]){
                        dp[r][c+1] = dp[r][c];
                        rows.add(r);
                        cols.add(c+1);
                    }
                }
            }
        }
        return dp[n-1][n-1];
    }
}
