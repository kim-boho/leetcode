package Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        ArrayList<Integer> charsIdx = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(Character.isLowerCase(arr[i])) charsIdx.add(i);
        }
        List<String> ans = new ArrayList<>();
        dfs(arr,ans,0,charsIdx);
        return ans;
    }

    private void dfs(char[] arr, List<String> ans, int count, ArrayList<Integer> charsIdx){
        if(count == charsIdx.size()){
            String s = new String(arr);
            ans.add(s);
            return;
        }
        dfs(arr,ans,count+1,charsIdx);
        arr[charsIdx.get(count)] = Character.toUpperCase(arr[charsIdx.get(count)]);
        dfs(arr,ans,count+1,charsIdx);
        arr[charsIdx.get(count)] = Character.toLowerCase(arr[charsIdx.get(count)]);
    }
}
