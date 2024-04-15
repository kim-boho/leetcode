package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] ans = new int[len];
        Arrays.sort(barcodes);
        ArrayList<int[]> nums = new ArrayList<>();
        int i=0;
        while(i < len){
            int start = i;
            int pre = barcodes[start];
            while(i < len && barcodes[i] == pre) i++;
            int[] temp = {barcodes[start],i-start};
            nums.add(temp);
        }
        nums.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        i = 0;
        int start = 0;
        int idx = start;
        int jump = len/nums.get(0)[1];
        if(len/2 < nums.get(0)[1]) jump++;
        for(; i<nums.size(); i++){
            int count = nums.get(i)[1];
            int num = nums.get(i)[0];
            while(count > 0){
                ans[idx] = num;
                count--;
                idx += jump;
                if(idx >= len){
                    start++;
                    idx = start;
                }
            }
        }
        return ans;
    }
}
