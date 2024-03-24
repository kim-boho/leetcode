package Easy;

public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String s:word1){
            sb.append(s);
        }
        for(String s:word2){
            sb2.append(s);
        }
        return sb.toString().contentEquals(sb2);
    }
}
