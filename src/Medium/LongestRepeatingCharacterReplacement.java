package Medium;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        char[] cArr = s.toCharArray();
        int idx = 0;
        int len = s.length();
        int ans = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);
            int tempK = k;
            int tempIdx = idx+1;
            while(tempIdx < len && tempK > 0){
                if(cArr[tempIdx] == c) tempIdx++;
                else{
                    tempIdx++;
                    tempK--;
                }
            }
            while(tempIdx < len && cArr[tempIdx] == c) tempIdx++;
            if(tempK>0){
                if(tempK >= idx) return len;
                else ans = Math.max(ans, len-idx+tempK);
            } else{
                ans = Math.max(ans, tempIdx-idx);
            }
            while(idx < len && cArr[idx] == c) idx++;
        }

        return ans;
    }
}
