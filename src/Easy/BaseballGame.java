package Easy;

import java.util.ArrayList;

public class BaseballGame {
    public int calPoints(String[] operations) {
        ArrayList<Integer> li = new ArrayList<>();
        for(String s:operations){
            if(s.equals("+")){
                li.add(li.get(li.size()-1)+li.get(li.size()-2));
            } else if(s.equals("D")){
                li.add(li.get(li.size()-1)*2);
            } else if(s.equals("C")){
                li.remove(li.get(li.size()-1));
            } else{
                li.add(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for(int i:li) sum += i;
        return sum;
    }
}
