package Easy;

public class MakeTwoArraysEqualByReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] occ = new int[1001];
        for(int i:target){
            occ[i]++;
        }
        for(int i:arr){
            occ[i]--;
            if(occ[i]<0) return false;
        }
        return true;
    }
}
