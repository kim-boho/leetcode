package Medium;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for(int[] update : updates){
            int val = update[2];
            ans[update[0]] += val;
            if(update[1] + 1 < length) ans[update[1]+1] -= val;
        }
        for(int i=1; i<length; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
