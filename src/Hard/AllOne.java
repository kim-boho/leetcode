package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class AllOne {
    HashMap<String,Integer> strings;
    TreeMap<Integer, HashSet<String>> counts;
    boolean isChanged;
    int min = -1;
    int max = -1;
    public AllOne() {
        strings = new HashMap<>();
        counts = new TreeMap<>();
        isChanged = false;
    }
    public void inc(String key) {
        if(strings.containsKey(key)){
            int curr = strings.get(key);
            if(curr == max) max = curr+1;
            if(curr == min && counts.get(curr).size() == 1) isChanged = true;
            strings.put(key,curr+1);
            if(counts.get(curr).size() == 1){
                isChanged = true;
                counts.remove(curr);
            } else{
                counts.get(curr).remove(key);
            }
        } else{
            strings.put(key,1);
            if(min == -1 || 1 < min) min = 1;
        }
        int newCount = strings.get(key);
        if(newCount > max) max = newCount;
        if(counts.containsKey(newCount)){
            counts.get(newCount).add(key);
        } else{
            HashSet<String> temp = new HashSet<>();
            temp.add(key);
            counts.put(newCount,temp);
        }
    }

    public void dec(String key) {
        int curr = strings.get(key);
        if(curr == 1){
            strings.remove(key);
        } else{
            strings.put(key,curr-1);
        }
        if(counts.get(curr).size() == 1){
            if(curr == min || curr == max) isChanged = true;
            counts.remove(curr);
        } else{
            counts.get(curr).remove(key);
        }
        if(counts.containsKey(curr-1)) counts.get(curr-1).add(key);
        else{
            if(curr-1 == 0) return;
            if(curr-1 < min) min = curr-1;
            HashSet<String> temp = new HashSet<>();
            temp.add(key);
            counts.put(curr-1,temp);
        }
    }

    public String getMaxKey() {
        if(counts.size() == 0) return "";
        if(max != -1 && !isChanged){
            return counts.get(max).iterator().next();
        } else{
            max = counts.lastEntry().getKey();
            min = counts.firstEntry().getKey();
            isChanged = false;
            return counts.get(max).iterator().next();
        }
    }

    public String getMinKey() {
        if(counts.size() == 0) return "";
        if(min != -1 && !isChanged){
            return counts.get(min).iterator().next();
        } else{
            max = counts.lastEntry().getKey();
            min = counts.firstEntry().getKey();
            isChanged = false;
            return counts.get(min).iterator().next();
        }
    }
}
