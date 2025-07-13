package Easy;

public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int evenSum = 0;
        int oddSum = 0;
        for(int i=0; i<position.length; i++){
            if(position[i] % 2 == 0) evenSum++;
            else oddSum++;
        }
        return Math.min(evenSum,oddSum);
    }
}
