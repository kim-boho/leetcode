package Easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int next = 0;
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=num.length-1; i>=0; i--){
            int dig = k%10+num[i]+next;
            k /= 10;
            next = dig > 9? 1:0;
            li.add(dig%10);
        }
        while(k > 0){
            int dig = k%10+next;
            k /= 10;
            next = dig > 9? 1:0;
            li.add(dig%10);
        }
        if(next == 1) li.add(1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=li.size()-1; i>=0; i--){
            ans.add(li.get(i));
        }
        return ans;
    }
}
