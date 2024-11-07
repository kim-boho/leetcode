package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int start = -1;
        if(arr[0] >= x){
            for(int i=0; i<k; i++){
                ans.add(arr[i]);
            }
            return ans;
        } else if(arr[arr.length-1] <= x){
            start = arr.length-k;
            for(int i=start; i<arr.length; i++){
                ans.add(arr[i]);
            }
            return ans;
        } else{
            int i=0;
            int j=arr.length;
            while(i <= j){
                int mid = i+(j-i)/2;
                if(mid-1 >= 0 && arr[mid-1]< x && x < arr[mid]){
                    i = mid-1;
                    j = mid;
                    break;
                } else if(arr[mid] == x || mid+1 < arr.length && arr[mid+1] > x && x > arr[mid]){
                    i = mid;
                    j = mid+1;
                    break;
                }
                if(arr[mid] > x) j = mid-1;
                else i = mid+1;
            }
            int count = 0;
            while(i >= 0 && j < arr.length && count < k){
                int leftGap = x-arr[i];
                int rightGap = arr[j]-x;
                if(leftGap <= rightGap) ans.add(arr[i--]);
                else ans.add(arr[j++]);
                count++;
            }
            if(count < k){
                while(count < k && j < arr.length){
                    ans.add(arr[j++]);
                    count++;
                }
                while(count < k && i >= 0){
                    ans.add(arr[i--]);
                    count++;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
