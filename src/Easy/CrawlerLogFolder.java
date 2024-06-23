package Easy;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int ans = 0;
        for(String s:logs){
            if(s.equals("../")){
                if(ans > 0) ans--;
            } else if(!s.equals("./")){
                ans++;
            }
        }
        return ans;
    }
}
