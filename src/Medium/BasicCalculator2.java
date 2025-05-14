package Medium;

import java.util.ArrayList;

public class BasicCalculator2 {
    public int calculate(String s) {
        s = s.replace(" ","");
        int i=0;
        ArrayList<Integer> li = new ArrayList<>();
        int prev = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                prev *= 10;
                prev += (s.charAt(i)-'0');
            } else{
                li.add(prev);
                prev = 0;
                char op = s.charAt(i);
                if(op == '+') li.add(0);
                else if(op == '-') li.add(1);
                else if(op == '*') li.add(2);
                else li.add(3);
            }
            i++;
        }
        li.add(prev);
        ArrayList<Integer> li2 = new ArrayList<>();
        for(i=0; i<li.size(); i++){
            if(i % 2 == 1 && li.get(i) > 1){
                int temp = li2.get(li2.size()-1);
                if(li.get(i) == 2){
                    temp *= li.get(i+1);
                } else{
                    temp /= li.get(i+1);
                }
                li2.set(li2.size()-1,temp);
                i++;
            } else{
                li2.add(li.get(i));
            }
        }
        int ans = li2.get(0);
        for(i=1; i<li2.size(); i+=2){
            if(li2.get(i) == 0){
                ans += li2.get(i+1);
            } else if(li2.get(i) == 1){
                ans -= li2.get(i+1);
            } else if(li2.get(i) == 2){
                ans *= li2.get(i+1);
            } else{
                ans /= li2.get(i+1);
            }
        }
        return ans;
    }
}
