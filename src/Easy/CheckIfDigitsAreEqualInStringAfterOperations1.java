package Easy;

import java.util.ArrayList;

public class CheckIfDigitsAreEqualInStringAfterOperations1 {
    public boolean hasSameDigits(String s) {
        ArrayList<Integer> li = new ArrayList<>();
        for(char c:s.toCharArray()){
            li.add(c-'0');
        }
        while(li.size() > 2){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<li.size()-1; i++){
                temp.add((li.get(i)+li.get(i+1))%10);
            }
            li = temp;
        }
        return li.get(0) == li.get(1);
    }
}
