package Easy;

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        boolean[] c = new boolean[10001];
        for(int n:nums){
            if(!c[n]) c[n] = true;
            else return n;
        }
        return -1;
    }
}
