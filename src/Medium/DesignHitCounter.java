package Medium;

import java.util.ArrayList;

public class DesignHitCounter {
    int start;
    ArrayList<Integer> li;
    public DesignHitCounter() {
        li = new ArrayList<>();
        start = 0;
    }

    public void hit(int timestamp) {
        li.add(timestamp);
    }

    public int getHits(int timestamp) {
        if(li.size() == 0 || start == li.size()) return 0;
        if(li.get(start) > timestamp-300){
            return li.size()-start;
        } else{
            while(start < li.size()){
                if(li.get(start) <= timestamp-300) start++;
                else return li.size()-start;
            }
            return 0;
        }
    }
}
