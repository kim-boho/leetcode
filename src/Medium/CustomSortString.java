package Medium;

public class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        char[] arrS = s.toCharArray();
        char[] arrO = order.toCharArray();
        int[] alp = new int[26];
        for(char c:arrS){
            alp[c-'a']++;
        }
        for(char c:arrO){
            while(alp[c-'a']>0){
                ans.append(c);
                alp[c-'a']--;
            }
        }
        for(int i=0; i<alp.length; i++){
            while(alp[i]>0){
                ans.append((char)(i+'a'));
                alp[i]--;
            }
        }
        return ans.toString();
    }
}
