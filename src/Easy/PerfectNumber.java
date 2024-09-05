package Easy;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        int pNum = 1;
        for(int i=2; i<=num/2; i++){
            if(num % i == 0) pNum += i;
        }
        return pNum == num;
    }
}
