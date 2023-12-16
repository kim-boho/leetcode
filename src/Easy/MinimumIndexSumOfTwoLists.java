package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm = new HashMap();
        for(int i=0; i<list1.length; i++){
            hm.put(list1[i],i);
        }
        int min = list1.length+list2.length;
        HashMap<String, Integer> hm2 = new HashMap();
        for(int i=0; i<list2.length; i++){
            if(hm.containsKey(list2[i])){
                if(min > hm.get(list2[i])+i) min = hm.get(list2[i])+i;
                hm2.put(list2[i],hm.get(list2[i])+i);
            }
        }
        ArrayList<String> li = new ArrayList();
        Iterator it = hm2.keySet().iterator();
        while(it.hasNext()){
            String s = (String) it.next();
            if(hm2.get(s) == min) li.add(s);
        }
        String[] ans = new String[li.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = li.get(i);
        }
        return ans;
    }
}
