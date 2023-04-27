package Hard;

public class PermutationSeq {
    int totalCount = 0;
    int[] tempPermus;
    boolean[] checked;
    int[] arr;
    boolean isDone = false;
    String result;
    public String getPermutation(int n, int k) {
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        checked = new boolean[n];
        tempPermus = new int[n];
        int count = 0;
        dfs(n, k, count);
        return result;
    }
    public void dfs(int n, int k, int count){
        if(!isDone){
            if(count==n){
                totalCount++;
                if(totalCount==k){
                    StringBuilder sb = new StringBuilder();
                    for(int i:tempPermus){
                        sb.append(i);
                    };
                    isDone = true;
                    result = sb.toString();
                }
            } else{
                for(int i=0; i<n; i++){
                    if(!checked[i]){
                        checked[i] = true;
                        tempPermus[count] = arr[i];
                        dfs(n, k, count+1);
                        checked[i] = false;
                    }
                }
            }
        }
    }
}
