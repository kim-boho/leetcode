package Easy;

public class NumberOfEvenAndOddBits {
    public int[] evenOddBit(int n) {
        boolean isEven = true;
        int[] ans = new int[2];
        while(n > 0){
            if(n % 2 == 1){
                if(isEven) ans[0]++;
                else ans[1]++;
            }
            n /= 2;
            isEven = !isEven;
        }
        return ans;
    }
}
