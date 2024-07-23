package Easy;

import java.util.Arrays;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        int[][] arr = new int[201][2];
        for(int i=0; i<arr.length; i++){
            arr[i][0] = i-100;
        }
        for(int n:nums){
            arr[n+100][1]++;
        }
        Arrays.sort(arr, (a, b)-> {
            if(b[1] == a[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i][1] != 0){
                int count = arr[i][1];
                for(int j=0; j<count; j++){
                    nums[idx++] = arr[i][0];
                }
            }
        }
        return nums;
    }
}
