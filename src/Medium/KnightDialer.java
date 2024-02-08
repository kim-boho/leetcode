package Medium;

import java.util.Arrays;

public class KnightDialer {
    public int knightDialer(int n) {
        if(n==1) return 10;
        long[] occr = new long[10];
        Arrays.fill(occr,1);
        n--;
        while(n > 0){
            long[] temp = new long[10];
            temp[0] = (occr[4]+occr[6])%(1000000000+7);
            temp[1] = (occr[6]+occr[8])%(1000000000+7);
            temp[2] = (occr[7]+occr[9])%(1000000000+7);
            temp[3] = (occr[4]+occr[8])%(1000000000+7);
            temp[4] = (occr[0]+occr[3]+occr[9])%(1000000000+7);
            temp[6] = (occr[0]+occr[1]+occr[7])%(1000000000+7);
            temp[7] = (occr[2]+occr[6])%(1000000000+7);
            temp[8] = (occr[1]+occr[3])%(1000000000+7);
            temp[9] = (occr[2]+occr[4])%(1000000000+7);
            occr = temp;
            n--;
        }
        long ans = 0;
        for(long i:occr) ans = (ans+i)%(1000000000+7);
        return (int)ans;
    }
}
