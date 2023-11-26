package Easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        String st1 = Integer.toBinaryString(x);
        String st2 = Integer.toBinaryString(y);
        int idx1 = st1.length()-1;
        int idx2 = st2.length()-1;
        int ans= 0;
        while(idx1 >= 0 && idx2 >= 0){
            if(st1.charAt(idx1--) != st2.charAt(idx2--)) ans++;
        }
        while(idx1 >= 0){
            if(st1.charAt(idx1--)=='1') ans++;
        }
        while(idx2 >= 0){
            if(st2.charAt(idx2--)=='1') ans++;
        }
        return ans;
    }
}
