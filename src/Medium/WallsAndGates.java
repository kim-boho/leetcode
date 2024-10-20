package Medium;

import java.util.ArrayList;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        ArrayList<Integer> nexts = new ArrayList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0) nexts.add(i*n+j);
            }
        }
        int dist = 1;

        while(!nexts.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i:nexts){
                int c = i % n;
                int r = (i-c) / n;
                if(r-1 >= 0 && rooms[r-1][c] > dist){
                    rooms[r-1][c] = dist;
                    temp.add(i-n);
                }
                if(c-1 >= 0 && rooms[r][c-1] > dist){
                    rooms[r][c-1] = dist;
                    temp.add(i-1);
                }
                if(r+1 < m && rooms[r+1][c] > dist){
                    rooms[r+1][c] = dist;
                    temp.add(i+n);
                }
                if(c+1 < n && rooms[r][c+1] > dist){
                    rooms[r][c+1] = dist;
                    temp.add(i+1);
                }
            }
            dist++;
            nexts = temp;
        }
    }
}
