package Easy;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        for(int i=0; i<word.length(); i++){
            if(ch == arr[i]){
                int j = 0;
                int k = i;
                while(j < k){
                    char temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                    j++;
                    k--;
                }
                break;
            }
        }
        return new String(arr);
    }
}
