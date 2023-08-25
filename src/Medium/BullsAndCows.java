package Medium;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] digitArr = new int[10];
        for(int i=0; i<secret.length(); i++){
            char c = secret.charAt(i);
            digitArr[c-'0']++;
        }

        int bull = 0;
        int cow = 0;
        for(int i=0; i<secret.length(); i++){
            char c = guess.charAt(i);
            if(secret.charAt(i) == c){
                digitArr[c-'0']--;
                bull++;
            }
        }

        for(int i=0; i<secret.length(); i++){
            char c = guess.charAt(i);
            if(secret.charAt(i) != c && digitArr[c-'0'] > 0){
                digitArr[c-'0']--;
                cow++;
            }
        }
        return bull+"A"+cow+"B";
    }
}
