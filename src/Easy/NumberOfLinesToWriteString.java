package Easy;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        int currentPxls = 0;
        for(char c:s.toCharArray()){
            int w = widths[c-'a'];
            if(currentPxls + w <= 100){
                currentPxls += w;
            } else{
                ans[0]++;
                currentPxls = w;
            }
        }
        ans[0]++;
        ans[1] = currentPxls;
        return ans;
    }
}
