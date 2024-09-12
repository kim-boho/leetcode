package Easy;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        boolean[] check = new boolean[26];
        for(int i=0; i<allowed.length(); i++){
            check[allowed.charAt(i)-'a'] = true;
        }
        for(String s:words){
            for(int i=0; i<s.length(); i++){
                if(!check[s.charAt(i)-'a']) break;
                if(i == s.length()-1) ans++;
            }
        }
        return ans;
    }
}
