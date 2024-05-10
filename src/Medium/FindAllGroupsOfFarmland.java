package Medium;

import java.util.ArrayList;

public class FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> li = new ArrayList<>();
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                if(land[i][j] == 1){
                    helper(land, i, j, li);
                }
            }
        }
        int[][] ans = new int[li.size()][4];
        for(int i=0; i<ans.length; i++){
            ans[i] = li.get(i);
        }
        return ans;
    }

    private void helper(int[][] land, int r, int c, ArrayList<int[]> li){
        int[] points = new int[4];
        points[0] = r;
        points[1] = c;
        int i = r;
        int j = c;
        while(i < land.length && land[i][j] == 1){
            i++;
        }
        i--;
        while(j < land[0].length && land[i][j] == 1){
            j++;
        }
        j--;
        points[2] = i;
        points[3] = j;
        li.add(points);
        for(; r<=i; r++){
            for(; c<=j; c++){
                land[r][c] = 0;
            }
            c=points[1];
        }
    }
}
