package Medium;

public class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        char[] ans = new char[s.length()+spaces.length];
        char[] str = s.toCharArray();
        int ansIdx= 0;
        int spcIdx = 0;
        int strIdx = 0;
        while(ansIdx < ans.length){
            if(spcIdx < spaces.length && spaces[spcIdx] == strIdx){
                ans[ansIdx++] = ' ';
                spcIdx++;
            } else{
                ans[ansIdx++] = str[strIdx++];
            }
        }
        return new String(ans);
    }
}
