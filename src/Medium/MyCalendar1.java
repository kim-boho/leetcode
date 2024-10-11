package Medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar1 {
    TreeMap<Integer,Integer> tm;
    public MyCalendar1() {
        tm = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry1 = tm.floorEntry(start);
        Map.Entry<Integer, Integer> entry2 = tm.ceilingEntry(start);
        if(entry1 != null && entry1.getValue() > start) return false;
        if(entry2 != null && entry2.getKey() < end) return false;
        tm.put(start,end);
        return true;
    }
}
