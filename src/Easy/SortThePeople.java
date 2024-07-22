package Easy;

import java.util.Arrays;

public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int[][] arr = new int[names.length][2];
        for(int i=0; i<arr.length; i++){
            arr[i][0] = heights[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
        String[] ans = new String[names.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = names[arr[i][1]];
        }

        return ans;
    }
}
