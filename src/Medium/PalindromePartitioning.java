package Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> li = new ArrayList<>();
        List<String> tempLi = new ArrayList<>();
        dfs(0, li, tempLi, s);
        return li;
    }

    private void dfs(int depth, List<List<String>> li, List<String> tempLi, String s){
        if(depth == s.length()){
            li.add(new ArrayList<>(tempLi));
            return;
        }

        for(int i=depth; i<s.length(); i++){
            if(isPalindrome(depth, i, s)){
                String temp = s.substring(depth,i+1);
                tempLi.add(temp);
                dfs(depth+temp.length(), li, tempLi, s);
                tempLi.remove(tempLi.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s){
        if(start == end) return true;
        else{
            while(start<end){
                if(s.charAt(start++) != s.charAt(end--)) return false;
            }
            return true;
        }
    }
}
