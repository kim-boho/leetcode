package Easy;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n+1];
        boolean[] b = new boolean[n+1];
        for(int[] temp:trust){
            t[temp[1]]++;
            b[temp[0]] = true;
        }
        for(int i=1; i<t.length; i++){
            if(t[i] == n-1 && !b[i]) return i;
        }
        return -1;
    }
}
