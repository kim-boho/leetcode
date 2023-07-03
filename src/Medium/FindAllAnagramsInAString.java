package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length()<p.length()) return ans;
        HashMap<Character, Integer> hm = new HashMap<>();
        int len = p.length();

        for(int i=0; i<len; i++){
            char temp = p.charAt(i);
            if(hm.containsKey(temp)) hm.put(temp, hm.get(temp)+1);
            else hm.put(temp, 1);
        }

        int left = 0;
        int right = 0;
        int count = len;
        int extra = 0;
        while(right<len){
            char temp = s.charAt(right++);
            if(hm.containsKey(temp)){
                hm.put(temp, hm.get(temp)-1);
                if(hm.get(temp)>=0){
                    count--;
                } else{
                    extra++;
                }
            }
        }

        if(extra == 0 && count == 0) ans.add(left);

        while(right<s.length()){
            char leftTemp = s.charAt(left);
            char rightTemp = s.charAt(right);
            if(hm.containsKey(leftTemp)){
                if(hm.get(leftTemp)<0) extra--;
                else count++;
                hm.put(leftTemp, hm.get(leftTemp)+1);
            }
            if(hm.containsKey(rightTemp)){
                if(hm.get(rightTemp)>0) count--;
                else extra++;
                hm.put(rightTemp, hm.get(rightTemp)-1);
            }
            left++;
            right++;
            if(count == 0 && extra == 0) ans.add(left);
        }
        return ans;
    }
}
