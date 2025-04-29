package Medium;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        int[] rabs = new int[1000];
        int ans = 0;
        for(int n:answers){
            if(n == 0) ans++;
            else{
                if(rabs[n] == 0){
                    ans += (n+1);
                    rabs[n] = n;
                } else{
                    rabs[n]--;
                }
            }
        }
        return ans;
    }
}
