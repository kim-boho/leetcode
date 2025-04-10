package Easy;

import java.util.ArrayList;

public class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> li = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i][0] < nums2[j][0]){
                li.add(nums1[i++]);
            } else if(nums1[i][0] > nums2[j][0]){
                li.add(nums2[j++]);
            } else{
                li.add(new int[] {nums1[i][0],nums1[i++][1]+nums2[j++][1]});
            }
        }
        while(i < nums1.length){
            li.add(nums1[i++]);
        }
        while(j < nums2.length){
            li.add(nums2[j++]);
        }
        int[][] ans = new int[li.size()][2];
        for(int k=0; k<ans.length; k++){
            ans[k] = li.get(k);
        }
        return ans;
    }
}
