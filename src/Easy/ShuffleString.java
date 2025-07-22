package Easy;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];
        char[] charArr = s.toCharArray();
        for(int i=0; i<charArr.length; i++){
            ans[indices[i]] = charArr[i];
        }
        return String.valueOf(ans);
    }
}
