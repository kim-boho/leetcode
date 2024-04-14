package Medium;

public class LetterTilePossibilities {
    int ans = 0;
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        int[] occs = new int[26];
        for(char c : arr) occs[c-'A']++;
        int[] alphas = new int[26];
        for(int i=1; i<=arr.length; i++) helper(i,occs,alphas,0, 0);
        return ans;
    }

    private void helper(int len, int[] occs, int[] alphas, int numLen, int start){
        if(numLen == len){
            int tempAns = 1;
            for(int i=2; i<=len; i++) tempAns *= i;
            for(int i:alphas){
                if(i > 1) for(int j=2; j<=i; j++) tempAns /= j;
            }
            ans += tempAns;
            return;
        }
        for(int i=start; i<occs.length; i++){
            if(occs[i] != 0){
                for(int j=1; j<=occs[i]; j++){
                    if(numLen+j <= len){
                        alphas[i] = j;
                        helper(len, occs, alphas, numLen+j, i+1);
                        alphas[i] = 0;
                    } else break;
                }
            }
        }
    }
}
