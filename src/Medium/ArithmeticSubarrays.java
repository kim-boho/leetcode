package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();
        for(int i=0; i<l.length; i++){
            int[] temp = new int[r[i]-l[i]+1];
            for(int j=l[i]; j<=r[i]; j++){
                temp[j-l[i]] = nums[j];
            }
            Arrays.sort(temp);
            int gap = temp[1]-temp[0];
            int prev = temp[1];
            boolean flag = true;
            for(int j=2; j<temp.length; j++){
                if(temp[j]-prev != gap){
                    flag = false;
                    break;
                }else{
                    prev = temp[j];
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}
