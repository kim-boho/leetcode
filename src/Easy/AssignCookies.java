package Easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int ans = 0;
        for(int i=0; i<g.length && j<s.length; i++){
            if(g[i] <= s[j]) ans++;
            else{
                while(j < s.length && s[j] < g[i]) j++;
                if(j==s.length) break;
                else ans++;
            }
            j++;
        }

        return ans;
    }
}
