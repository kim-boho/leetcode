package Hard;

public class MaximumCandiesYouCanGetFromBoxes {
    int ans = 0;
    boolean[] check;
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        check = new boolean[status.length];

        for(int i=0; i<status.length; i++){
            if(status[i] == 1) unlock(keys,i,status);
        }

        for(int i=0; i<initialBoxes.length; i++){
            int idx = initialBoxes[i];
            addCandies(status,idx,candies,containedBoxes);
        }
        return ans;
    }

    private void unlock(int[][] keys, int curr, int[] status){
        for(int k:keys[curr]){
            if(status[k] == 0){
                status[k] = 1;
                unlock(keys,k,status);
            }
        }
    }

    private void addCandies(int[] status, int curr, int[] candies, int[][] containedBoxes){
        if(status[curr] == 0) return;
        if(!check[curr]){
            check[curr] = true;
            ans += candies[curr];
        }
        for(int b:containedBoxes[curr]) addCandies(status,b,candies,containedBoxes);
    }
}
