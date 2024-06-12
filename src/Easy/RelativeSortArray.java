package Easy;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] occ = new int[1001];
        for(int i:arr1) occ[i]++;
        int p=0;
        for(int i:arr2){
            while(occ[i]>0){
                arr1[p++] = i;
                occ[i]--;
            }
        }
        for(int i=0; i<occ.length; i++){
            while(occ[i] > 0){
                arr1[p++] = i;
                occ[i]--;
            }
        }
        return arr1;
    }
}
