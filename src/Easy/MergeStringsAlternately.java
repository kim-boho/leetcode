package Easy;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(),word2.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        String longer = word1.length() == len? word2:word1;
        sb.append(longer.substring(len));
        return sb.toString();
    }
}
