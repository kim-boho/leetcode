package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // long strings, short array
        List<List<String>> ans = new ArrayList<>();
        List<String> emptyLi = new ArrayList<>();
        for(String str: strs){
            if(str.length() == 0){
                emptyLi.add("");
            }
        }
        if(emptyLi.size()>0) ans.add(emptyLi);
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            if(str.length() == 0) continue;
            List<String> angrms = new ArrayList<>();
            angrms.add(str);
            int[] alphabets = new int[26];
            for(int j=0; j<str.length(); j++){
                alphabets[str.charAt(j) - 'a']++;
            }
            int[] temp = alphabets.clone();
            for(int k=i+1; k<strs.length; k++){
                if(strs[k].length() == 0) continue;
                boolean isAnagram = true;
                for(int l = 0; l<strs[k].length() && isAnagram; l++){
                    temp[strs[k].charAt(l)-'a']--;
                    if(temp[strs[k].charAt(l)-'a'] < 0){
                        isAnagram = false;
                        break;
                    }
                }
                for(int rem : temp){
                    if(rem > 0) isAnagram = false;
                }
                if(isAnagram){
                    angrms.add(strs[k]);
                    strs[k] = "";
                }
                temp = alphabets.clone();
            }
            ans.add(angrms);
        }
        return ans;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // long array, short strings
        List<char[]> li = new ArrayList<>();
        for(String str:strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            li.add(chArr);
        }
        List<List<String>> ans = new ArrayList<>();
        boolean[] checked = new boolean[strs.length];
        for(int i=0; i<strs.length; i++){
            if(checked[i]) continue;
            List<String> li2 = new ArrayList<>();
            checked[i] = true;
            li2.add(strs[i]);
            for(int j=i+1; j<strs.length; j++){
                if(Arrays.equals(li.get(i), li.get(j))){
                    li2.add(strs[j]);
                    checked[j] = true;
                }
            }
            ans.add(li2);
        }

        return ans;
    }
}
