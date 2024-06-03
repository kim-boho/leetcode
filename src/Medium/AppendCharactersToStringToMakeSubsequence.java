package Medium;

public class AppendCharactersToStringToMakeSubsequence {
    public int appendCharacters(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int j = 0;
        for (char c : sChar) {
            if (j == tChar.length) return 0;
            if (c == tChar[j]) j++;
        }
        return tChar.length-j;
    }
}
