package Easy;

public class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        char[] arr = s.toCharArray();
        int[] chars = new int[26];
        for(char c:arr){
            chars[c-'a']++;
        }
        char[] arr2 = target.toCharArray();
        int[] targetChars = new int[26];
        for(char c:arr2){
            targetChars[c-'a']++;
        }
        int ans = arr.length;
        for(int i=0; i<26; i++){
            if(targetChars[i] != 0) ans = Math.min(ans,chars[i]/targetChars[i]);
        }
        return ans;
    }
}
