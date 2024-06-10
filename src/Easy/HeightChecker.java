package Easy;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = new int[101];
        for(int h:heights) expected[h]++;
        int ans = 0;
        int i = 1;
        int j= 0;
        while(i < 101){
            if(expected[i] == 0) i++;
            else{
                if(i != heights[j]) ans++;
                j++;
                expected[i]--;
            }
        }
        return ans;
    }
}
