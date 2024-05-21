package Medium;

import java.util.Arrays;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[][] arr2 = new int[(arr.length-1)*arr.length/2][2];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                arr2[count][0] = arr[i];
                arr2[count++][1] = arr[j];
            }
        }
        Arrays.sort(arr2, (a, b) -> Double.compare((double)a[0]/(double)a[1], (double)b[0]/(double)b[1]));
        return arr2[k-1];
    }
}
