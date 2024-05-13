package Easy;

public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int ans = 0;
        int ones = 0;
        int zeroes = 0;
        char[] arr = s.toCharArray();
        for(int i:arr){
            if(i=='1') ones++;
        }
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == '0'){
                zeroes++;
            } else{
                ones--;
            }
            ans = Math.max(zeroes+ones,ans);
        }
        return ans;
    }
}
