package Easy;

public class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int jumpIdx = arr.length/4;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == arr[i+jumpIdx]) return arr[i];
        }
        return 0;
    }
}
