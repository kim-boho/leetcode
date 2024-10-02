package Medium;

public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int[] rems = new int[k];
        int[] negRems = new int[k];
        for(int n:arr){
            if(n < 0){
                negRems[-(n % k)]++;
            } else{
                rems[n % k]++;
            }
        }
        if((rems[0]+negRems[0]) % 2 != 0) return false;
        if(k % 2 == 0 && (rems[k/2]+negRems[k/2]) % 2 != 0) return false;

        int end = k % 2 == 0? k/2-1:k/2;
        for(int i=1; i<=end; i++){
            if((rems[i]+negRems[k-i]) != (rems[k-i]+negRems[i])) return false;
        }
        return true;
    }
}
