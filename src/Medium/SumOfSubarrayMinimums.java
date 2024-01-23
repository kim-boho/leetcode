package Medium;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        for(int i=0; i<arr.length; i++){
            int min = arr[i];
            for(int j=i; j<arr.length; j++){
                if(min > arr[j]) min = arr[j];
                ans += min;
            }
        }
        return (int) (ans % (long)(1000000000+7));
    }
}
