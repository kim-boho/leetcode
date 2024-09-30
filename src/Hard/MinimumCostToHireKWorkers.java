package Hard;

import java.util.Arrays;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double [][] values = new double[wage.length][2];
        for(int i=0; i<wage.length; i++){
            values[i][0] = quality[i];
            values[i][1] = (double)wage[i] / (double)quality[i];
        }
        double ans = Double.MAX_VALUE;
        Arrays.sort(values, (a, b) -> Double.compare(a[0], b[0]));
        for(int i=0; i<quality.length; i++){
            double avg = values[i][1];
            int count = 1;
            double sum = avg*values[i][0];
            for(int j=0; j<quality.length; j++){
                if(count == k) break;
                if(j == i) continue;
                if(values[j][1] <= avg){
                    count++;
                    sum += avg*values[j][0];
                }
            }
            if(count == k){
                ans = Math.min(ans,sum);
            }
        }
        return ans;
    }
}
