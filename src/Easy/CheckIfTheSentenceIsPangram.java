package Easy;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] chars = new boolean[26];
        int count = 0;
        for(char c:sentence.toCharArray()){
            if(!chars[c-'a']){
                chars[c-'a'] = true;
                count++;
                if(count == 26) return true;
            }
        }
        return false;
    }
}
