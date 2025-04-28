package Medium;

public class NumberOfAdjacentElementsWithTheSameColor {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] adj = new int[queries.length];
        int[] cols = new int[n];
        int count = 0;
        int i = 0;
        for(int[] q:queries){
            if(cols[q[0]] == q[1]){
                adj[i++] = count;
                continue;
            }
            if(q[0]-1 >= 0 && cols[q[0]-1] != 0){
                if(cols[q[0]-1] == q[1]) count++;
                else if(cols[q[0]-1] == cols[q[0]]) count--;
            }
            if(q[0]+1 < n && cols[q[0]+1] != 0){
                if(cols[q[0]+1] == q[1]) count++;
                else if(cols[q[0]+1] == cols[q[0]]) count--;
            }
            cols[q[0]] = q[1];
            adj[i++] = count;
        }
        return adj;
    }
}
