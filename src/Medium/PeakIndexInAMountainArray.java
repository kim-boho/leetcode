package Medium;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 3) return 1;
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]) return mid;
            if(arr[mid-1] > arr[mid+1]) right = mid;
            else left = mid;
        }
        return -1;
    }
}
