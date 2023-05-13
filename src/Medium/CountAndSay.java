package Medium;

import java.util.ArrayList;

public class CountAndSay {
    public String countAndSay(int n) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(1);
        while(n>1){
            int i=0;
            ArrayList<Integer> temp = new ArrayList<>();
            while(i<li.size()){
                int current = li.get(i);
                int count = 0;
                int next = i;
                while(next<li.size() && li.get(next) == current){
                    next++;
                    count++;
                }
                temp.add(count);
                temp.add(current);
                i = next;
            }
            li = temp;
            n--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<li.size(); i++){
            sb.append(li.get(i));
        }
        return sb.toString();
    }
}
