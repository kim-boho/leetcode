package Easy;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[0] > target || letters[letters.length-1] <= target) return letters[0];
        for(int i=0; i<letters.length-1; i++){
            if(letters[i] <= target && letters[i+1] > target) return letters[i+1];
        }
        return 0;
    }
}
