package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class BraceExpansion {
    public String[] expand(String s) {
        ArrayList<Character> li = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        helper(s,0,li,ans);
        String[] arr = new String[ans.size()];
        for(int i=0; i<arr.length; i++) arr[i] = ans.get(i);
        Arrays.sort(arr);
        return arr;
    }
    private void helper(String s, int i, ArrayList<Character> li, ArrayList<String> ans){
        if(i >= s.length()){
            StringBuilder sb = new StringBuilder();
            for(char c:li) sb.append(c);
            ans.add(sb.toString());
            return;
        }
        if(s.charAt(i) == '{'){
            int j = i+1;
            while(s.charAt(j) != '}') j++;
            char[] arr = s.substring(i+1,j).replace(",","").toCharArray();
            for(char c:arr){
                li.add(c);
                helper(s,j+1,li,ans);
                li.remove(li.size()-1);
            }
        } else{
            li.add(s.charAt(i));
            helper(s,i+1,li,ans);
            li.remove(li.size()-1);
        }
    }
}
