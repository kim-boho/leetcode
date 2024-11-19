package Medium;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] check = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!check[i]){
                ans++;
                checkNodes(i,isConnected,check);
            }
        }
        return ans;
    }

    private void checkNodes(int node, int[][] isConnected, boolean[] check){
        int[] conn = isConnected[node];
        for(int i=0; i<conn.length; i++){
            if(i != node && !check[i] && conn[i] == 1){
                check[i] = true;
                checkNodes(i,isConnected,check);
            }
        }
    }
}
