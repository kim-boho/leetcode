package Easy;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] arr = num.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            if(left == right){
                if(arr[left] == '8' || arr[left] == '0' || arr[left] == '1') return true;
                else return false;
            } else{
                if(arr[left] == '8' || arr[left] == '0' || arr[left] == '1'){
                    if(arr[right] != arr[left]) return false;
                } else if(arr[left] == '6'){
                    if(arr[right] != '9') return false;
                } else  if(arr[left] == '9'){
                    if(arr[right] != '6') return false;
                } else return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
