package Easy;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<3){
            return n > 0;
        }
        String s = Integer.toBinaryString(n);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '1') return false;
        }
        return true;
    }
}
