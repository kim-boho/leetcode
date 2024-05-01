package Easy;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 1;
        while(right < arr.length){
            if(Character.toLowerCase(arr[left]) == Character.toLowerCase(arr[right]) && arr[left] != arr[right]){
                arr[left] = '0';
                arr[right] = '0';
                while(left >= 0 && arr[left] == '0') left--;
                if(left == -1){
                    left = right+1;
                    right++;
                }
            } else{
                left = right;
            }
            right++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c:arr){
            if(c != '0') sb.append(c);
        }
        return sb.toString();
    }
}
