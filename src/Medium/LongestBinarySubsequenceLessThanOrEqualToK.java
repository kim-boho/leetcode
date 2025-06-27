package Medium;

public class LongestBinarySubsequenceLessThanOrEqualToK {
    public int longestSubsequence(String s, int k) {
        String bs = Integer.toBinaryString(k);
        if(bs.length() > s.length()) return s.length();
        int len = bs.length();
        int ans = 0;
        int zeros = 0;
        for(int i=0; i<s.length()-bs.length()+1; i++){
            if(s.charAt(i) != '0'){
                String temp = s.substring(i,i+len);
                if(Integer.parseInt(temp, 2) <= k){
                    ans = Math.max(ans,zeros+len);
                }
            } else zeros++;
        }
        ans = Math.max(ans,zeros+len-1);
        return ans;
    }
}
