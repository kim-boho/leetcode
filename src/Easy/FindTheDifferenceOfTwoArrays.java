package Easy;

import java.util.ArrayList;
import java.util.List;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int[] arr1 = new int[2001];
        int[] arr2 = new int[2001];
        for(int n:nums1){
            arr1[n+1000]++;
        }
        for(int n:nums2){
            arr2[n+1000]++;
        }
        for(int i=0; i<2001; i++){
            if(arr1[i] != 0 && arr2[i] == 0) ans.get(0).add(i+-1000);
            else if(arr1[i] == 0 && arr2[i] != 0) ans.get(1).add(i+-1000);
        }
        return ans;
    }
}
