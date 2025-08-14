package Medium;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    List<String> ans;
    public List<String> generateAbbreviations(String word) {
        char[] arr = word.toCharArray();
        ans = new ArrayList<>();
        ArrayList<Character> li = new ArrayList<>();
        dfs(0,arr,li);
        return ans;
    }

    private void dfs(int i, char[] arr, ArrayList<Character> li){
        if(i >= arr.length){
            StringBuilder sb = new StringBuilder(li.size());
            for(char c:li) sb.append(c);
            ans.add(sb.toString());
            return;
        }
        li.add(arr[i]);
        dfs(i+1,arr,li);
        li.remove(li.size()-1);
        for(int j=0; j+i<arr.length; j++){
            int num = j+1;
            if(num >= 10) li.add('1');
            li.add((char)(num%10+'0'));
            if(j+i+1 < arr.length) li.add(arr[j+i+1]);
            dfs(i+j+2,arr,li);
            li.remove(li.size()-1);
            if(num >= 10) li.remove(li.size()-1);
            if(j+i+1 < arr.length) li.remove(li.size()-1);
        }
    }
}
