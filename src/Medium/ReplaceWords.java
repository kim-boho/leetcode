package Medium;

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Letters[] arr = new Letters[26];
        for(String s:dictionary){
            Letters[] nextArr = arr;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(nextArr[c-'a'] == null){
                    Letters temp = new Letters(c);
                    nextArr[c-'a'] = temp;
                }
                if(i == s.length()-1){
                    nextArr[c-'a'].isDone = true;
                    break;
                }
                nextArr = nextArr[c-'a'].nexts;
            }
        }
        String[] stArr = sentence.split(" ");
        for(int j=0; j<stArr.length; j++){
            String s = stArr[j];
            StringBuilder sb = new StringBuilder();
            Letters[] nextArr = arr;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(nextArr[c-'a'] != null){
                    sb.append(c);
                    if(nextArr[c-'a'].isDone){
                        stArr[j] = sb.toString();
                        break;
                    }
                } else{
                    break;
                }
                nextArr = nextArr[c-'a'].nexts;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stArr.length; i++){
            sb.append(stArr[i]);
            if(i != stArr.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

class Letters {
    char val;
    Letters[] nexts;
    boolean isDone;
    Letters(char val){
        this.val = val;
        nexts = new Letters[26];
        isDone = false;
    }
}
