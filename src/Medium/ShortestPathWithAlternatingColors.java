package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red, int[][] blue) {
        int[][] bfs = new int[n][2];
        for(int[] arr:bfs) Arrays.fill(arr,-1);
        bfs[0][0] = 0;
        bfs[0][1] = 0;
        boolean[][] redEdges = new boolean[n][n];
        boolean[][] blueEdges = new boolean[n][n];
        for(int[] arr:red){
            redEdges[arr[0]][arr[1]] = true;
        }
        for(int[] arr:blue){
            blueEdges[arr[0]][arr[1]] = true;
        }
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(0);
        while(nodes.size() > 0){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int node:nodes){
                boolean[] reds = redEdges[node];
                boolean[] blues = blueEdges[node];
                for(int i=0; i<n; i++){
                    if(reds[i]){
                        if(bfs[node][1] != -1 && (bfs[i][0] == -1 || bfs[i][0] > bfs[node][1]+1)){
                            bfs[i][0] = bfs[node][1]+1;
                            temp.add(i);
                        }
                    }
                    if(blues[i]){
                        if(bfs[node][0] != -1 && (bfs[i][1] == -1 || bfs[i][1] > bfs[node][0]+1)){
                            bfs[i][1] = bfs[node][0]+1;
                            temp.add(i);
                        }
                    }
                }
            }
            nodes = temp;
        }
        int[] ans = new int[n];
        for(int i=0; i<ans.length; i++){
            if(bfs[i][0] == -1 && bfs[i][1] == -1) ans[i] = -1;
            else if(bfs[i][0] == -1) ans[i] = bfs[i][1];
            else if(bfs[i][1] == -1) ans[i] = bfs[i][0];
            else ans[i] = Math.min(bfs[i][0],bfs[i][1]);
        }
        return ans;
    }
}
