package Medium;

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[][] arr = new int[26][2];
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        if(len == 1) return s;
        else if(len == 2) return charArr[0] == charArr[1]? "":s;
        int limit = (len+1)/2;
        for(char c:charArr){
            arr[c-'a'][0]++;
            arr[c-'a'][1] = c-'a';
            if(limit < arr[c-'a'][0]) return "";
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int gap = (len+1)/arr[0][0];
        int idx = 0;
        char[] ansArr = new char[len];
        for(int i=0; i<gap; i++){
            for(int j=i; j<len; j += gap){
                if(arr[idx][0] == 0) idx++;
                arr[idx][0]--;
                ansArr[j] = (char)(arr[idx][1]+'a');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:ansArr) sb.append(c);
        return sb.toString();
    }
}
