package Easy;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[]  chars = new boolean[26];
        boolean[]  chars2 = new boolean[26];
        for(char c:jewels.toCharArray()){
            if(Character.isUpperCase(c)) chars[c-'A'] = true;
            else chars2[c-'a'] = true;
        }
        int ans = 0;
        for(char c:stones.toCharArray()){
            if(Character.isUpperCase(c)){
                if(chars[c-'A']) ans++;
            } else{
                if(chars2[c-'a']) ans++;
            }
        }
        return ans;
    }
}
