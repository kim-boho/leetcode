package Medium;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left < right){
            if(arr[left] == arr[right]){
                while(left+1 < right && arr[left+1] == arr[left]) left++;
                while(right-1 > left && arr[right-1] == arr[right]) right--;
                left++;
                right--;
            } else{
                break;
            }
        }

        if(left < right) return right-left+1;
        else if(left == right) return 1;
        else return 0;
    }
}
