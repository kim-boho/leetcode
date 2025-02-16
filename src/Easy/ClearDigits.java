package Easy;

import java.util.Arrays;

public class ClearDigits {
    public String clearDigits(String s) {
        char[] arr = s.toCharArray();
        char[] ans = new char[arr.length];
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(Character.isLowerCase(arr[i])) ans[j++] = arr[i];
            else{
                j--;
            }
        }
        return new String(Arrays.copyOfRange(ans,0,j));
    }
}
