package Medium;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        char[] arr = new char[n];
        makeNums(0,arr.length-1,arr,ans);
        return ans;
    }

    private void makeNums(int left, int right, char[] arr, List<String> ans){
        if(left > right) ans.add(new String(arr));
        else if(left == right){
            arr[left] = '0';
            ans.add(new String(arr));
            arr[left] = '1';
            ans.add(new String(arr));
            arr[left] = '8';
            ans.add(new String(arr));
        } else{
            if(left != 0){
                arr[left] = '0';
                arr[right] = '0';
                makeNums(left+1,right-1,arr,ans);
            }
            arr[left] = '1';
            arr[right] = '1';
            makeNums(left+1,right-1,arr,ans);
            arr[left] = '8';
            arr[right] = '8';
            makeNums(left+1,right-1,arr,ans);
            arr[left] = '6';
            arr[right] = '9';
            makeNums(left+1,right-1,arr,ans);
            arr[left] = '9';
            arr[right] = '6';
            makeNums(left+1,right-1,arr,ans);
        }
    }
}
