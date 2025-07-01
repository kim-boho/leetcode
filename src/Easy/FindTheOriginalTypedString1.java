package Easy;

public class FindTheOriginalTypedString1 {
    public int possibleStringCount(String word) {
        int ans = 1;
        char prev = 'A';
        for(char c:word.toCharArray()){
            if(c == prev){
                ans++;
            } else{
                prev = c;
            }
        }
        return ans;
    }
}
