package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SortVowelsInAString {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        ArrayList<Character> li = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(isVowels(arr[i])){
                li.add(arr[i]);
                arr[i] = '*';
            }
        }
        char[] vowels = new char[li.size()];
        for(int i=0; i<vowels.length; i++){
            vowels[i] = li.get(i);
        }
        Arrays.sort(vowels);
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '*'){
                arr[i] = vowels[count++];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
