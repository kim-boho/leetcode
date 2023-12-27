package Easy;

public class NumberComplement {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        int times = 1;
        int ans = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                ans += times;
            }
            times *= 2;
        }
        return ans;
    }
}
