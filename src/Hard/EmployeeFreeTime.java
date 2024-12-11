package Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(List<Interval> w:schedule){
            for(Interval in:w){
                tm.put(in.start, Math.max(in.end, tm.getOrDefault(in.start,0)));
            }
        }
        int prevStart = tm.firstKey();
        int prevEnd = tm.get(tm.firstKey());
        TreeMap<Integer,Integer> tm2 = new TreeMap<>();
        for(int key:tm.keySet()){
            if(key <= prevEnd) prevEnd = Math.max(tm.get(key),prevEnd);
            else{
                tm2.put(prevStart,prevEnd);
                prevStart = key;
                prevEnd = Math.max(tm.get(key),prevEnd);
            }
        }
        tm2.put(prevStart,prevEnd);
        List<Interval> ans = new ArrayList<>();
        prevEnd = -1;
        for(int key:tm2.keySet()){
            if(prevEnd == -1) prevEnd = tm2.get(key);
            else{
                Interval in = new Interval(prevEnd,key);
                ans.add(in);
                prevEnd = tm2.get(key);
            }
        }
        return ans;
    }
}
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}
