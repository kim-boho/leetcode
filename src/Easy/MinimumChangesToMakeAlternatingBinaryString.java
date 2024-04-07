package Easy;

public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int evenIdxIsZero = 0;
        int evenIdxIsOne = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(i % 2 == 0){
                if(arr[i] == '0'){
                    evenIdxIsOne++;
                } else{
                    evenIdxIsZero++;
                }
            } else{
                if(arr[i] == '0'){
                    evenIdxIsZero++;
                } else{
                    evenIdxIsOne++;
                }
            }
        }
        return Math.min(evenIdxIsZero, evenIdxIsOne);
    }
}
