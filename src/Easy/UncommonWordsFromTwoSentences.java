package Easy;

import java.util.HashSet;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        HashSet<String> hs = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        for(String s:arr1){
            if(hs.contains(s)) ans.remove(s);
            else{
                hs.add(s);
                ans.add(s);
            }
        }
        for(String s:arr2){
            if(hs.contains(s)) ans.remove(s);
            else{
                hs.add(s);
                ans.add(s);
            }
        }
        String[] ansArr = new String[ans.size()];
        int i = 0;
        for(String s:ans){
            ansArr[i++] = s;
        }
        return ansArr;
    }
}
