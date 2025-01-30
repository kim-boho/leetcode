package Easy;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        String firNum = Integer.toBinaryString(left);
        String lastNum = Integer.toBinaryString(right);
        int[] isPrimes = new int[lastNum.length()+1];
        char[] bits = new char[lastNum.length()];
        int bitCount = 0;
        char[] firstBits = firNum.toCharArray();
        int gap = lastNum.length()-firNum.length();
        for(int i=0; i<firstBits.length; i++){
            char b = firstBits[i];
            if(b == '1') bitCount++;
            bits[i+gap] = b;
        }
        left++;
        int ans = 0;
        if(isPrime(bitCount)){
            isPrimes[bitCount] = 1;
            ans++;
        }
        while(left <= right){
            for(int i=bits.length-1; i>=0; i--){
                if(bits[i] == '1'){
                    bits[i] = '0';
                    bitCount--;
                } else {
                    bits[i] = '1';
                    bitCount++;
                    break;
                }
            }
            if(isPrimes[bitCount] == 1) ans++;
            else if(isPrimes[bitCount] == 0){
                if(isPrime(bitCount)){
                    ans++;
                    isPrimes[bitCount] = 1;
                } else isPrimes[bitCount] = -1;
            }
            left++;
        }
        return ans;
    }

    private boolean isPrime(int n){
        if(n == 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
