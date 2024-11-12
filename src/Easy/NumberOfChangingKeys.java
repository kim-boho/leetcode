package Easy;

public class NumberOfChangingKeys {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int ans = 0;
        char[] cs = s.toCharArray();
        char prev = cs[0];
        for(int i=1; i<cs.length; i++){
            if(prev != cs[i]) ans++;
            prev = cs[i];
        }
        return ans;
    }
}
