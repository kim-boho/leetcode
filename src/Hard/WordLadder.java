package Hard;

import java.util.HashSet;
import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        hs.remove(beginWord);
        if(!hs.contains(endWord)) return 0;
        HashSet<String> q = new HashSet<>();
        q.add(beginWord);
        int count = 1;
        while(!q.isEmpty()){
            HashSet<String> temp = new HashSet<>();
            for(String curr:q){
                if(curr.equals(endWord)){
                    return count;
                }
                isConnected(curr,hs,temp);
                hs.remove(curr);
            }
            q = temp;
            count++;
        }
        return 0;
    }

    private void isConnected(String s1, HashSet<String> hs, HashSet<String> temp){
        char[] arr = s1.toCharArray();
        for(int j=0; j<arr.length; j++){
            char orginal = arr[j];
            for(char i='a'; i<='z'; i++){
                arr[j] = i;
                String changedString = String.valueOf(arr);
                if(hs.contains(changedString)) temp.add(changedString);
            }
            arr[j] = orginal;
        }
    }
}
