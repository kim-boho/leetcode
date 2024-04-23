package Easy;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int max = 0;
        for(int n:nums){
            arr[n]++;
            if(arr[n] > max) max = arr[n];
        }
        int ans = 0;
        for(int n:arr){
            if(n == max) ans += n;
        }
        return ans;
    }
}
