package Medium;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int i=0;
        while(i < arr.length){
            while(i < arr.length && arr[i] != '.') i++;
            if(i == arr.length) break;
            int right = i+1;
            while(right < arr.length && arr[right] == '.') right++;
            int left = i-1;
            i = right;
            if(left < 0 && right == arr.length) break;
            else if(left < 0){
                if(arr[right] == 'L'){
                    left = 0;
                    while(left < right) arr[left++] = 'L';
                }
            } else if(right == arr.length){
                if(arr[left] == 'R'){
                    while(left < right) arr[left++] = 'R';
                }
            } else{
                if(arr[left] == 'R' && arr[right] == 'L'){
                    left++;
                    right--;
                    while(left < right){
                        arr[left++] = 'R';
                        arr[right--] = 'L';
                    }
                } else if(arr[left] == 'R') {
                    left++;
                    while(left < right){
                        arr[left++] = 'R';
                    }
                } else if(arr[right] == 'L') {
                    right--;
                    while(left < right){
                        arr[right--] = 'L';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:arr) sb.append(c);
        return sb.toString();
    }
}
