package Easy;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int max = arr[arr.length-1];
        ans[arr.length-1] = -1;
        for(int i=arr.length-2; i>=0; i--){
            int temp = arr[i];
            ans[i] = max;
            if(temp > max) max = temp;
        }
        return ans;
    }
}
