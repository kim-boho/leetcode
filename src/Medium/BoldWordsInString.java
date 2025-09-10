package Medium;

public class BoldWordsInString {
    public String boldWords(String[] words, String s) {
        int[] boldWords = new int[s.length()];
        for(String word : words){
            int startIdx = 0;
            int len = word.length();
            int idxNum = s.indexOf(word,startIdx);
            while(idxNum != -1){
                boldWords[idxNum] = Math.max(len,boldWords[idxNum]);
                startIdx ++;
                idxNum = s.indexOf(word,startIdx);
            }
        }
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<boldWords.length; i++){
            if(boldWords[i] == 0){
                sb.append(sArr[i]);
            } else{
                sb.append("<b>");
                int endIdx = i+boldWords[i];
                while(i < endIdx){
                    endIdx = Math.max(endIdx,i+boldWords[i]);
                    if(i+1 < boldWords.length && boldWords[i+1] != 0) endIdx = Math.max(endIdx,boldWords[i+1]+i+1);
                    sb.append(sArr[i]);
                    i++;
                }
                sb.append("</b>");
                i--;
            }
        }
        return sb.toString();
    }
}
