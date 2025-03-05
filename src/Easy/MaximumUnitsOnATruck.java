package Easy;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] boxes = new int[1001];
        for(int[] arr:boxTypes){
            boxes[arr[1]] += arr[0];
        }
        int ans = 0;
        for(int i=1000; i>0 && truckSize > 0; i--){
            ans += (Math.min(truckSize,boxes[i])*i);
            truckSize -= boxes[i];
        }
        return ans;
    }
}
