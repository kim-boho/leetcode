package Medium;

public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int count = 0;
        long ans = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') count++;
            else ans += count;
        }
        return ans;
    }
}
