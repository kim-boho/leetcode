package Easy;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        boolean asc = true;
        for(int i=1; i<arr.length; i++){
            if(asc){
                if(arr[i-1] > arr[i]){
                    if(i == 1) return false;
                    asc = false;
                    continue;
                }
                if(arr[i-1] >= arr[i]) return false;
            } else{
                if(arr[i-1] <= arr[i]) return false;
            }
        }
        return !asc;
    }
}
