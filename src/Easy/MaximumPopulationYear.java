package Easy;

public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int[] ppl = new int[101];
        for(int[] l:logs){
            ppl[l[0]-1950]++;
            ppl[l[1]-1950]--;
        }
        int max = ppl[0];
        int ans = 1950;
        for(int i=1; i<ppl.length; i++){
            ppl[i] += ppl[i-1];
            if(max < ppl[i]){
                max = ppl[i];
                ans = i+1950;
            }
        }
        return ans;
    }
}
