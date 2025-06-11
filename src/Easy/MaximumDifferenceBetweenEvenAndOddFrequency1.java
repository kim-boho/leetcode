package Easy;

public class MaximumDifferenceBetweenEvenAndOddFrequency1 {
    public int maxDifference(String s) {
        int a1 = 0;
        int a2 = s.length();
        int[] chars = new int[26];
        for(char c:s.toCharArray()){
            chars[c-'a']++;
        }
        for(int i:chars){
            if(i % 2 == 1 && a1 < i) a1 = i;
            else if(i != 0 && i % 2 == 0 && a2 > i) a2 = i;
        }
        return a1-a2;
    }
}
