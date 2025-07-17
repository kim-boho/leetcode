package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticWaterFlow {
    int m;
    int n;
    HashSet<Integer> pac;
    HashSet<Integer> atl;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        pac = new HashSet<>();
        atl = new HashSet<>();
        for(int i=0; i<m; i++){
            dfs(heights,i,0,'p',0);
            dfs(heights,i,n-1,'a',0);
        }
        for(int j=0; j<n; j++){
            dfs(heights,0,j,'p',0);
            dfs(heights,m-1,j,'a',0);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int num = n*i+j;
                if(pac.contains(num) && atl.contains(num)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int r, int c, char ocean, int prevHeight){
        if(r < 0 || c < 0 || r >= m || c >= n) return;
        HashSet<Integer> temp = ocean == 'p'? pac:atl;
        int num = n*r+c;
        if(temp.contains(num)) return;
        int h = heights[r][c];
        if(h >= prevHeight){
            temp.add(num);
            dfs(heights,r-1,c,ocean,h);
            dfs(heights,r+1,c,ocean,h);
            dfs(heights,r,c-1,ocean,h);
            dfs(heights,r,c+1,ocean,h);
        }
    }
}
