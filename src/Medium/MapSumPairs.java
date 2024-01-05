package Medium;

import java.util.HashMap;

public class MapSumPairs {
    HashMap<String, Integer> hm;
    HashMap<String, Integer> st;
    public MapSumPairs() {
        hm = new HashMap();
        st = new HashMap();
    }

    public void insert(String key, int val) {
        if(st.containsKey(key)){
            int temp = val;
            val -= st.get(key);
            st.put(key, temp);
        } else st.put(key, val);

        for(int i=1; i<=key.length(); i++){
            String sub = key.substring(0,i);
            if(hm.containsKey(sub)){
                hm.put(sub, hm.get(sub)+val);
            } else{
                hm.put(sub, val);
            }
        }
    }

    public int sum(String prefix) {
        return hm.getOrDefault(prefix, 0);
    }
}
