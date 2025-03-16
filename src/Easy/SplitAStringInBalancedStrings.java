package Easy;

public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int r = 0;
        int l = 0;
        for(char c:s.toCharArray()){
            if(c == 'R') r++;
            else l++;
        }
        int r2 = 0;
        int l2 = 0;
        for(char c:s.toCharArray()){
            if(c == 'R'){
                r2++;
                r--;
            } else{
                l2++;
                l--;
            }
            if(r == l && r2 == l2) ans++;
        }
        return ans;
    }
}
