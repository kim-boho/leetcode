package Easy;

public class MinimumMovesToConvertString {
    public int minimumMoves(String s){
        int ans = 0;
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i) == 'X'){
                ans++;
                i += 3;
            } else i++;
        }
        return ans;
    }
}
