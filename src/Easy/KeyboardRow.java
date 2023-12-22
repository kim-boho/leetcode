package Easy;

import java.util.ArrayList;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        int[] arr = new int[26];
        for(char c='a'; c <= 'z'; c++){
            if(c=='q' || c=='w' || c=='e' || c=='r' || c=='t' || c=='y' || c=='u' || c=='i' || c=='o' || c=='p'){
                arr[c-'a'] = 1;
            } else if(c=='a' || c=='s' || c=='d' || c=='f' || c=='g' || c=='h' || c=='j' || c=='k' || c=='l'){
                arr[c-'a'] = 2;
            } else{
                arr[c-'a'] = 3;
            }
        }
        ArrayList<String> ans = new ArrayList();
        for(int i=0; i<words.length; i++){
            char[] cArr = words[i].toLowerCase().toCharArray();
            int row = arr[cArr[0] - 'a'];
            for(int j=1; j<cArr.length; j++){
                if(row != arr[cArr[j] - 'a']){
                    row = -1;
                    break;
                }
            }
            if(row != -1){
                ans.add(words[i]);
            }
        }
        String[] ansArr = new String[ans.size()];
        for(int i=0; i<ansArr.length; i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}
