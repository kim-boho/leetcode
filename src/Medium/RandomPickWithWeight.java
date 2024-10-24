package Medium;

import java.util.Random;

public class RandomPickWithWeight {
    int[] pb;
    Random rd;
    public RandomPickWithWeight(int[] w) {
        long sum = 0;
        for(int n:w) sum += n;
        int totalLen = 0;
        for(int i=0; i<w.length; i++){
            w[i] = (int)(((double)w[i]/(double)sum)*(double)100);
            w[i] = Math.max(1,w[i]);
            totalLen += w[i];
        }
        pb = new int[totalLen];
        int idx = 0;
        for(int i=0; i<w.length; i++){
            for(int j=0; j<w[i]; j++){
                pb[idx++] = i;
            }
        }
        rd = new Random();
    }

    public int pickIndex() {
        return pb[rd.nextInt(pb.length)];
    }
}
