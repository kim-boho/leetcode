package Medium;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public int numSteps(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == '1'){
                if(i == 0) break;
                ans++;
                while(i>=0 && arr[i] == '1'){
                    ans++;
                    i--;
                }
                if(i>=0) arr[i] = '1';
                i++;
            } else{
                ans++;
            }
        }
        return ans;
    }
}
