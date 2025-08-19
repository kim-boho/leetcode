package Medium;

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int ans = 0;
        int idx = 0;
        for(int i=0; i<rows; i++){
            int remainingSpace = cols;
            while(remainingSpace >= sentence[idx].length()){
                remainingSpace -= sentence[idx++].length()+1;
                if(idx == sentence.length){
                    idx = 0;
                    ans++;
                }
            }
        }
        return ans;
    }
}
