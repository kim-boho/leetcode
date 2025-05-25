package Easy;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int n:nums){
            boolean isEven = true;
            while(n > 0){
                isEven = !isEven;
                n /= 10;
            }
            if(isEven) ans++;
        }
        return ans;
    }
}
