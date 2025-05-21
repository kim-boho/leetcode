package Easy;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] letters = new int[26];
        for(int i=0; i<licensePlate.length(); i++){
            char c = licensePlate.charAt(i);
            if(c >= 'a' && c <= 'z') letters[c-'a']++;
        }
        String ans = null;
        for(String s:words){
            int[] temp = new int[26];
            for(int i=0; i<s.length(); i++){
                temp[s.charAt(i)-'a']++;
            }
            boolean isAns = true;
            for(int i=0; i<temp.length; i++){
                if(temp[i] < letters[i]){
                    isAns = false;
                    break;
                }
            }
            if(isAns){
                if(ans == null || ans.length() > s.length()) ans = s;
            }
        }
        return ans;
    }
}
