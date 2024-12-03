package Medium;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    HashMap<String, TreeMap<Integer,String>> hm;
    public TimeBasedKeyValueStore() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> tm;
        if(hm.containsKey(key)){
            tm = hm.get(key);
        } else{
            tm = new TreeMap<>();
            hm.put(key,tm);
        }
        tm.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        if(hm.get(key).firstKey() > timestamp) return "";
        return hm.get(key).get(hm.get(key).floorKey(timestamp));
    }
}
