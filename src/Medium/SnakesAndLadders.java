package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        int[] minDiceNum = new int[n*n+1];
        Arrays.fill(minDiceNum,n*n);
        minDiceNum[1] = 0;
        Queue<Integer> nextCheckCells = new ArrayDeque<>();
        nextCheckCells.add(1);
        while(!nextCheckCells.isEmpty()){
            int cellNum = nextCheckCells.poll();
            for(int next=cellNum+1; next<=Math.min(cellNum+6,n*n); next++){
                int tempNext = next;
                int nextRow = n-1 - (tempNext-1) / n;
                int nextCol = tempNext - (n-1-nextRow)*n - 1;
                if((n + nextRow) % 2 == 0) nextCol = n-nextCol-1;
                if(board[nextRow][nextCol] != -1){
                    tempNext = board[nextRow][nextCol];
                }
                if(minDiceNum[tempNext] > minDiceNum[cellNum]+1){
                    if(tempNext == n*n) return minDiceNum[cellNum]+1;
                    nextCheckCells.add(tempNext);
                    minDiceNum[tempNext] = minDiceNum[cellNum]+1;
                }
            }
        }
        return -1;
    }
}
