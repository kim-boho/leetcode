package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BuildAMatrixWithConditions {
    boolean valid = true;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        boolean[][] rowDeg = new boolean[k+1][k+1];
        int[] rowCount = new int[k+1];
        makeDegrees(rowDeg, rowCount, rowConditions);

        ArrayList<Integer> sortedRow = new ArrayList<>();
        topologicalSort(sortedRow, rowDeg, rowCount);
        if(!valid || sortedRow.size() < k) return new int[0][];

        boolean[][] colDeg = new boolean[k+1][k+1];
        int[] colCount = new int[k+1];
        makeDegrees(colDeg, colCount, colConditions);

        ArrayList<Integer> sortedCol = new ArrayList<>();
        topologicalSort(sortedCol, colDeg, colCount);
        if(!valid || sortedCol.size() < k) return new int[0][];

        int[][] ans = new int[k][k];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<sortedCol.size(); i++){
            hm.put(sortedCol.get(i),i);
        }
        for(int i=0; i<sortedRow.size(); i++){
            ans[i][hm.get(sortedRow.get(i))] = sortedRow.get(i);
        }

        return valid? ans : new int[0][];
    }

    private void makeDegrees(boolean[][] degrees, int[] count, int[][] conditions){
        for(int[] c: conditions){
            int n1 = c[0];
            int n2 = c[1];
            if(!degrees[n1][n2]) count[n2]++;
            degrees[n1][n2] = true;
        }
    }

    private void topologicalSort(ArrayList<Integer> li, boolean[][] degrees, int[] count){
        int k = count.length-1;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<count.length; i++){
            if(count[i] == 0) q.add(i);
        }

        while(valid && !q.isEmpty()){
            Queue<Integer> temp = new LinkedList<>();
            while(valid && !q.isEmpty()){
                int n = q.poll();
                boolean[] nextNodes = degrees[n];
                li.add(n);
                for(int i=1; i<nextNodes.length; i++){
                    if(nextNodes[i]){
                        count[i]--;
                        if(count[i] == 0){
                            temp.add(i);
                        } else if(count[i]<0){
                            valid = false;
                            break;
                        }
                    }
                }
            }
            q = temp;
        }
    }
}
