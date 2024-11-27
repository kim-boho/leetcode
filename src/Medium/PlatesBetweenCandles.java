package Medium;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] q) {
        int[] lefts = new int[s.length()];
        int[] counts = new int[s.length()];
        int[] rights = new int[s.length()];
        char[] arr = s.toCharArray();
        int prev = -1;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '|'){
                prev = i;
                count++;
            }
            lefts[i] = prev;
            counts[i] = count;
        }
        prev = -1;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == '|') prev = i;
            rights[i] = prev;
        }
        int[] ans = new int[q.length];
        for(int i=0; i<q.length; i++){
            int start = q[i][0];
            int end = q[i][1];
            int l = rights[start];
            int r = lefts[end];
            if(start == end || l >= r){
                arr[i] = 0;
                continue;
            }
            ans[i] = r-l-(counts[r]-counts[l]);
        }
        return ans;
    }
}
