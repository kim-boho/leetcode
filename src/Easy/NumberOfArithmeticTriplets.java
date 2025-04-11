package Easy;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] arr = new boolean[201];
        for(int i:nums) arr[i] = true;
        int ans = 0;
        for(int i=0; i <= 200-2*diff; i++){
            if(arr[i] && arr[i+diff] && arr[i+diff*2]) ans++;
        }
        return ans;
    }
}
