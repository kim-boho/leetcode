package Medium;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+","/");
        String[] words = s.split("/");
        StringBuilder sb = new StringBuilder("");
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]+" ");
        }

        return sb.toString().trim();
    }
}
