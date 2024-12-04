package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for(String s:words){
            hm.put(s,hm.getOrDefault(s,0)+1);
            max = Math.max(max,hm.get(s));
        }
        TreeSet<String>[] arr = new TreeSet[max];
        for(String key:hm.keySet()){
            if(arr[hm.get(key)-1] == null) arr[hm.get(key)-1] = new TreeSet<>();
            arr[hm.get(key)-1].add(key);
        }
        List<String> ans = new ArrayList<>();
        int count = 0;
        for(int i=arr.length-1; i>=0 && count < k; i--){
            TreeSet<String> ts = arr[i];
            if(ts == null) continue;
            for(String s:ts){
                if(count < k){
                    ans.add(s);
                    count++;
                } else break;
            }
        }
        return ans;
    }
}
