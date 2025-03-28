package Easy;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) return true;
        char[] arr = s.toCharArray();
        int j = arr.length-1;
        char[] arr2 = goal.toCharArray();
        char st = goal.charAt(0);
        char e = goal.charAt(arr.length-1);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == st && arr[j] == e){
                int k = i;
                boolean isEqual = true;
                for(int m=0; m<arr2.length; m++){
                    if(arr2[m] != arr[k%arr.length]){
                        isEqual = false;
                        break;
                    }
                    k++;
                }
                if(isEqual) return true;
            }
            j = i;
        }
        return false;
    }
}
