package Easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            while(j < t.length() && s.charAt(i) != t.charAt(j)) j++;
            if(j < t.length()){
                i++;
                j++;
            } else{
                if(i < t.length()) return false;
                else return true;
            }
        }
        return i < s.length()? false:true;
    }
}
