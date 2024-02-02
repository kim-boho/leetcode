package Medium;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int minDig = 0;
        int lowFirst = 0;
        int temp = low;
        while(temp>0){
            minDig++;
            temp /= 10;
        }
        int maxDig = 0;
        temp = high;
        while(temp>0){
            maxDig++;
            temp /= 10;
        }
        List<Integer> li = new ArrayList();
        while(minDig<=maxDig){
            for(int i=1; i<10; i++){
                int ans = 0;
                boolean isAnswer = true;
                for(int j=0; j<minDig; j++){
                    if(i+j < 10){
                        ans += (i+j);
                        ans *= 10;
                    } else{
                        isAnswer = false;
                        break;
                    }
                }
                ans /= 10;
                if(isAnswer && ans >= low && ans <= high){
                    li.add(ans);
                }
            }
            minDig++;
        }
        return li;
    }
}
