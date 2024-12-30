package Easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left; i<=right; i++){
            char[] arr = String.valueOf(i).toCharArray();
            boolean isNum = true;
            for(int j=0; isNum && j<arr.length; j++){
                if(arr[j] == '0'){
                    isNum = false;
                    break;
                }
                if(i % (int)(arr[j]-'0') != 0){
                    isNum = false;
                }
            }
            if(isNum) ans.add(i);
        }
        return ans;
    }
}
