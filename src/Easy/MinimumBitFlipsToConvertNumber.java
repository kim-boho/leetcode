package Easy;

public class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        int minL = Math.min(s.length(),g.length());
        int maxL = Math.max(s.length(),g.length());
        int diff = maxL - minL;
        int ans = 0;
        String longer = null;
        String shorter = null;
        if(minL == s.length()){
            longer = g;
            shorter = s;
        } else{
            longer = s;
            shorter = g;
        }
        for(int i=0; i<diff; i++){
            if(longer.charAt(i) == '1') ans++;
        }
        for(int i=0; i<minL; i++){
            if(longer.charAt(diff+i) != shorter.charAt(i)) ans++;
        }
        return ans;
    }
}
