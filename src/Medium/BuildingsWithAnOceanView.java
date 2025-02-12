package Medium;

import java.util.Arrays;

public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] h) {
        int len = h.length;
        int[] arr = new int[len];
        int idx = len-1;
        arr[idx] = idx;
        for(int i=len-2; i>=0; i--){
            if(h[i]>h[arr[idx]]) arr[--idx] = i;
        }
        return Arrays.copyOfRange(arr,idx,len);
    }
}
