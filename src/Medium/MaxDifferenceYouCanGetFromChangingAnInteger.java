package Medium;

import java.util.ArrayList;

public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        ArrayList<Integer> li = new ArrayList<>();
        int temp = num;
        while(temp > 0){
            li.add(temp%10);
            temp /= 10;
        }
        int x1 = li.get(li.size()-1);
        if(x1 == 9){
            for(int i=li.size()-2; i>=0; i--){
                if(li.get(i) != 9){
                    x1 = li.get(i);
                    break;
                }
            }
        }
        int x2 = li.get(li.size()-1);
        int min = 1;
        if(x2 == 1){
            for(int i=li.size()-2; i>=0; i--){
                if(li.get(i) > 1){
                    x2 = li.get(i);
                    break;
                }
            }
            if(x2 != 1) min = 0;
        }
        int num1 = 0;
        int num2 = 0;
        for(int i=li.size()-1; i>=0; i--){
            int n = li.get(i);
            num1 *= 10;
            if(n == x1) num1 += 9;
            else num1 += n;
            num2 *= 10;
            if(n == x2) num2 += min;
            else num2 += n;
        }
        return num1-num2;
    }
}
