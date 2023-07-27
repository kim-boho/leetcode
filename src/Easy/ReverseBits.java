package Easy;

public class ReverseBits {
    public int reverseBits(int n) {
        String st = Integer.toBinaryString(n);
        while(st.length()<32) st = "0"+st;
        int ans = 0;
        int twoPow = 1;
        for(int i=0; i<st.length(); i++){
            ans += twoPow*(st.charAt(i)-'0');
            twoPow *= 2;
        }
        return ans;
    }
}
