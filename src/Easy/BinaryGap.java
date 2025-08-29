package Easy;

public class BinaryGap {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] binary = binaryString.toCharArray();
        int ans = 0;
        int i = 0;
        while(i < binary.length && binary[i] == '0') i++;
        for(int j=i+1; j<binary.length; j++){
            if(binary[j] == '1'){
                ans = Math.max(ans,j-i);
                i = j;
            }
        }
        return ans;
    }
}
