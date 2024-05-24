package Hard;

public class MaximumScoreWordsFormedByLetters {
    int ans = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        char[] ableChars = new char[26];
        for(char c:letters) ableChars[c-'a']++;
        char[][] occurences = new char[words.length][26];
        for(int i=0; i<words.length; i++){
            char[] temp = words[i].toCharArray();
            for(char c:temp) occurences[i][c-'a']++;
        }
        addWords(0, 0, ableChars, occurences, score);
        return ans;
    }

    private int canMakeWord(char[] occ, char[] ableChars, int[] score){
        int sum = 0;
        for(int i=0; i<26; i++){
            if(occ[i] > ableChars[i]){
                for(int j=0; j<i; j++) ableChars[j] += occ[j];
                return 0;
            }
            else {
                sum += (occ[i]*score[i]);
                ableChars[i] -= occ[i];
            }
        }
        return sum;
    }

    private void addCharsAgain(char[] occ, char[] ableChars){
        for(int i=0; i<26; i++){
            ableChars[i] += occ[i];
        }
    }

    private void addWords(int i, int s, char[] ableChars, char[][] occurences, int[] score){
        if(i == occurences.length){
            ans = Math.max(ans, s);
            return;
        }
        int addedScore = canMakeWord(occurences[i],ableChars,score);
        if(addedScore > 0){
            addWords(i+1, s+addedScore, ableChars, occurences,score);
            addCharsAgain(occurences[i],ableChars);
        }

        addWords(i+1, s, ableChars, occurences,score);
    }
}
