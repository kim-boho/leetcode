package Easy;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int c = strs[0].length();
        int ans = 0;
        char[][] arr = new char[r][c];
        for(int i=0; i<r; i++){
            arr[i] = strs[i].toCharArray();
        }
        for(int i=0; i<c; i++){
            char prev = 'a';
            for(int j=0; j<r; j++){
                if(prev > arr[j][i]){
                    ans++;
                    break;
                }
                prev = arr[j][i];
            }
        }
        return ans;
    }
}
