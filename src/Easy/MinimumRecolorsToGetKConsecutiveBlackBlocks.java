package Easy;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        int i=0;
        int j=0;
        int wCount = 0;
        char[] arr = blocks.toCharArray();
        for(; j<k; j++){
            if(arr[j] == 'W') wCount++;
        }
        int ans = wCount;
        for(; j<arr.length; j++){
            if(arr[j] == 'W') wCount++;
            if(arr[i++] == 'W') wCount--;
            ans = Math.min(ans,wCount);
        }
        return ans;
    }
}
