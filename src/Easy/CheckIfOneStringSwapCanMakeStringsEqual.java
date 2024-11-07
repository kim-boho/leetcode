package Easy;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int count = 0;
        int idx1 = -1;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 2) return false;
                else if(count == 2){
                    if(s1.charAt(idx1) == s2.charAt(i) && s2.charAt(idx1) == s1.charAt(i)) continue;
                    else return false;
                } else{
                    idx1 = i;
                }
            }
        }
        return count == 2;
    }
}
