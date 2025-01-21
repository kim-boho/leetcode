package Easy;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int remainder = n%2;
        n /= 2;
        while(n > 0){
            if(n%2 == remainder) return false;
            remainder = n%2;
            n /= 2;
        }
        return true;
    }
}
