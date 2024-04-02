package Medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        int len = (int)Math.pow(2,n);
        boolean[] checked = new boolean[len+1];
        checked[0] = true;
        int[] digits = new int[n];
        int num = 0;
        ans.add(0);
        for(int i=1; i<len; i++){
            for(int j=0; j<n; j++){
                int temp = (int)Math.pow(2,j);
                if(digits[j] == 1) temp *= -1;
                if(!checked[num + temp]){
                    digits[j] = digits[j] == 0? 1:0;
                    num += temp;
                    checked[num] = true;
                    ans.add(num);
                    break;
                }
            }
        }
        return ans;
    }
}
