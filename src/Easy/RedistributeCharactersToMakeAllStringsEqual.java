package Easy;

public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        int[] alphas = new int[26];
        for(String word:words){
            char[] arr = word.toCharArray();
            for(char c:arr) alphas[c-'a']++;
        }
        int n = words.length;
        for(int i:alphas){
            if(i % n != 0) return false;
        }
        return true;
    }
}
