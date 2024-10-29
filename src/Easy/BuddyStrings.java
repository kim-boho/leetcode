package Easy;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        int sz = s.length();
        if(sz < 2 || sz != goal.length()) return false;
        int fir = -1;
        int sec = -1;
        int[] chars = new int[26];
        boolean canSwap = false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(++chars[c-'a'] >= 2) canSwap = true;
            if(c != goal.charAt(i)){
                if(fir == -1) fir = i;
                else if(sec == -1){
                    if(s.charAt(fir) != goal.charAt(i)) return false;
                    sec = i;
                } else return false;
            }
        }
        if(fir == -1){
            return canSwap;
        } else if(sec == -1) return false;
        return s.charAt(fir) == goal.charAt(sec) && s.charAt(sec) == goal.charAt(fir);
    }
}
