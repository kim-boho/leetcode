package Easy;

import java.util.Arrays;
import java.util.HashMap;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s:arr){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        int count = 0;
        for(String s:arr){
            if(hm.get(s) == 1){
                count++;
                if(count == k) return s;
            }
        }
        return "";
    }
}
