package Easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] b = new boolean[nums.length+1];
        for(int n:nums) b[n] = true;

        for(int i=0; i<b.length; i++){
            if(!b[i]) return i;
        }
        return -1;
    }
}
