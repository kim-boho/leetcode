package Medium;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] isMultiple = new boolean[n];
        for(int i=2; i<Math.sqrt(n); i++){
            int temp = i*2;
            while(temp<n){
                isMultiple[temp] = true;
                temp += i;
            }
        }
        int ans = 0;
        for(int i=2; i<n; i++){
            if(!isMultiple[i]) ans++;
        }
        return ans;
    }
}
