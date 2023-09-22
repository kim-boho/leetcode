package Medium;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        else{
            int uniqueNum = 9;
            int multiple = 9;
            for(int i=1; i<n; i++){
                uniqueNum *= multiple--;
            }
            return countNumbersWithUniqueDigits(n-1)+uniqueNum;
        }
    }
}
