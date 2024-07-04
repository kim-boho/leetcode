package Hard;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    int setNum = 1;
    int ans = 0;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if(edges.length < n-1) return -1;
        int[] checkedA = new int[n+1];
        int[] checkedB = new int[n+1];

        for(int[] e:edges){
            if(e[0] == 3){
                checkEdge(checkedA,e[1],e[2]);
            }
        }

        for(int i=1; i<n+1; i++) checkedB[i] = checkedA[i];

        for(int[] e:edges){
            int e1 = e[1];
            int e2 = e[2];
            if(e[0] == 1){
                checkEdge(checkedA,e1,e2);
            } else if(e[0] == 2){
                checkEdge(checkedB,e1,e2);
            }
        }

        int setNumA = checkedA[1];
        if(setNumA == 0) return -1;
        for(int i=2; i<n+1; i++){
            if(setNumA != checkedA[i]) return -1;
        }
        int setNumB = checkedB[1];
        if(setNumB == 0) return -1;
        for(int i=2; i<n+1; i++){
            if(setNumB != checkedB[i]) return -1;
        }
        return edges.length-ans;
    }

    private void checkEdge(int[] c, int e1, int e2){
        if(c[e1] == 0 && c[e2] == 0){
            c[e1] = setNum;
            c[e2] = setNum;
            setNum++;
            ans++;
        } else if(c[e1] != 0 && c[e2] != 0){
            int setNum1 = c[e1];
            int setNum2 = c[e2];
            if(setNum1 == setNum2) return;
            for(int i=1; i<c.length; i++){
                if(c[i] == setNum2) c[i] = setNum1;
            }
            ans++;
        } else if(c[e1] != 0){
            c[e2] = c[e1];
            ans++;
        } else if(c[e2] != 0){
            c[e1] = c[e2];
            ans++;
        }
    }
}
