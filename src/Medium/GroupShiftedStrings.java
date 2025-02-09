package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<Integer,HashMap<int[], ArrayList<String>>> hm = new HashMap<>();
        for(String s : strings){
            int l = s.length();
            int[] diffs = new int[l];
            char[] charArr = s.toCharArray();
            for(int i=0; i<l; i++){
                char c = charArr[i];
                char next = charArr[(i+1)%l];
                int diff = next-c;
                if(diff >= 0) diffs[i] = diff;
                else diffs[i] = 26+diff;
            }
            HashMap<int[],ArrayList<String>> tempHm;
            if(hm.containsKey(l)) tempHm = hm.get(l);
            else{
                tempHm = new HashMap<>();
                hm.put(l,tempHm);
            }
            boolean isAdded = false;
            for(int[] arr: tempHm.keySet()){
                if(Arrays.equals(diffs,arr)){
                    tempHm.get(arr).add(s);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded){
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(s);
                tempHm.put(diffs,tempList);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(int key : hm.keySet()){
            HashMap<int[],ArrayList<String>> stringHm = hm.get(key);
            for(int[] keyArr:stringHm.keySet()){
                ArrayList<String> li = stringHm.get(keyArr);
                ans.add(li);
            }
        }
        return ans;
    }
}
