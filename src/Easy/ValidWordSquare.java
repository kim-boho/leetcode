package Easy;

import java.util.List;

public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for(int i=0; i<words.size(); i++){
            String s = words.get(i);
            int len = s.length();
            int j = 0;
            for(; j<len; j++){
                if(j == i) continue;
                if(j >= words.size()) return false;
                String temp = words.get(j);
                if(temp.length() > i){
                    if(temp.charAt(i) != s.charAt(j)) return false;
                } else return false;
            }
        }
        return true;
    }
}
