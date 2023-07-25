package Medium;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] arr = new int[n+1];
        int sqrt = (int) Math.sqrt(n);
        for(int i=1; i<n+1; i++) arr[i] = i;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<=sqrt; j++){
                if(i-j*j<0) break;
                else if(i == j*j) arr[i] = 1;
                else{
                    if(arr[i-j*j]+1<arr[i]) arr[i] = arr[i-j*j]+1;
                }
            }
        }

        return arr[n];
    }
}
