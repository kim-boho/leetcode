package Easy;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n<4) return false;
        String s = Integer.toBinaryString(n);
        if((s.length()-1) % 2 != 0) return false;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i++) == '1') return false;
        }
        return true;
    }
}
