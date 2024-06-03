package Medium;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int n:nums) xor ^= n;
        String s = Integer.toBinaryString(k);
        String x = Integer.toBinaryString(xor);
        int i=0;
        int ans = 0;
        String min = null;
        String max = null;
        if(x.length()>s.length()){
            max = x;
            min = s;
        } else{
            max = s;
            min = x;
        }
        int gap = max.length()-min.length();
        while(i<gap){
            if(max.charAt(i) == '1') ans++;
            i++;
        }
        while(i<max.length()){
            if(max.charAt(i) != min.charAt(i-gap)) ans++;
            i++;
        }
        return ans;
    }
}
