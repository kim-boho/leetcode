package Easy;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0; i<4; i++){
            int n = num%10;
            if(n != 0) li.add(n);
            num /= 10;
        }
        if(li.size() == 1) return li.get(0);
        else if(li.size() == 2) return li.get(0)+li.get(1);
        else if(li.size() == 3){
            Collections.sort(li);
            return li.get(0)*10+li.get(1)+li.get(2);
        } else{
            Collections.sort(li);
            return li.get(0)*10+li.get(1)*10+li.get(2)+li.get(3);
        }
    }
}
