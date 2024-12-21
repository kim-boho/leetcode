package Easy;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        for(int n:arr){
            if(num != n){
                if(n-num < k){
                    k -= (n-num);
                    num = n+1;
                } else{
                    return num+k-1;
                }
            } else num++;
        }
        return num+k-1;
    }
}
