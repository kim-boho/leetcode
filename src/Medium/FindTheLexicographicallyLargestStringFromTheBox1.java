package Medium;

public class FindTheLexicographicallyLargestStringFromTheBox1 {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        char[] chars = word.toCharArray();
        char max = 'a';
        for(char c:chars){
            if(c > max) max = c;
        }
        if(numFriends == word.length()) return String.valueOf(max);
        String ans = String.valueOf(max);
        int len = word.length()-numFriends+1;
        for(int i=0; i<word.length(); i++){
            if(chars[i] == max){
                int maxIdx = Math.min(word.length(),i+len);
                String temp = word.substring(i,maxIdx);

                if(ans.compareTo(temp) < 0) ans = temp;
            }
        }
        return ans;
    }
}
