package Easy;

public class LongestUnequalAdjacentGroupsSubsequence1 {
    public int minMaxDifference(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        char minChar = chars[0];
        char maxChar = chars[0];
        for(int i=0; i<chars.length; i++){
            if(chars[i] != '9'){
                maxChar = chars[i];
                break;
            }
        }
        int min = 0;
        int max = 0;
        for(int i=0; i<chars.length; i++){
            char temp = chars[i];
            min *= 10;
            max *= 10;
            if(temp != minChar) min += (int)(chars[i]-'0');
            if(temp == maxChar) temp = '9';
            max += (int)(temp-'0');
        }
        return max - min;
    }
}
