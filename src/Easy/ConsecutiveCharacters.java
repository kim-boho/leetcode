package Easy;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int ans = 0;
        int count = 0;
        char prev = '-';
        for(char c : s.toCharArray()){
            if(prev == c) count++;
            else{
                ans = Math.max(ans,count);
                prev = c;
                count = 1;
            }
        }
        ans = Math.max(ans,count);
        return ans;
    }
}
