package Easy;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int p = 0;
        int i = 0;
        for(; i<abbr.length(); i++){
            if(p >= word.length()) return false;
            char c = abbr.charAt(i);
            if(Character.isDigit(c)){
                if(c == '0') return false;
                else{
                    int j = i+1;
                    while(j<abbr.length() && Character.isDigit(abbr.charAt(j))) j++;
                    int n = Integer.parseInt(abbr.substring(i,j));
                    p += n;
                    i = j-1;
                }
            } else{
                if(c != word.charAt(p)) return false;
                else p++;
            }
        }
        return p == word.length() && i == abbr.length();
    }
}
