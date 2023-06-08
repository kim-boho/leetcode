package Medium;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> keyValue;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyValue = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(keyValue.containsKey(key)){
            int val = (int) keyValue.remove(key);
            keyValue.put(key, val);
            return val;
        } else return -1;
    }

    public void put(int key, int value) {
        if(keyValue.containsKey(key)){
            keyValue.remove(key);
        } else{
            if(capacity == 0){
                int firstKey = (int) keyValue.keySet().iterator().next();
                keyValue.remove(firstKey);
            } else{
                capacity--;
            }
        }
        keyValue.put(key, value);
    }
}
