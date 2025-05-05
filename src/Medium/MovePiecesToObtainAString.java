package Medium;

public class MovePiecesToObtainAString {
    public boolean canChange(String start, String target) {
        char[] arr = target.toCharArray();
        char[] sArr = start.toCharArray();
        int p = 0;
        int i = 0;
        while(i < arr.length){
            while(i < arr.length && arr[i] == '_') i++;
            if(i < arr.length){
                if(arr[i] == 'L'){
                    while(p < sArr.length && sArr[p] == '_') p++;
                    if(p == sArr.length || sArr[p] == 'R') return false;
                    else{
                        if(p < i) return false;
                    }
                    p++;
                } else{
                    while(p < sArr.length && sArr[p] == '_') p++;
                    if(p == sArr.length || sArr[p] == 'L') return false;
                    else{
                        if(p > i) return false;
                    }
                    p++;
                }
                i++;
            }
        }
        for(; p < sArr.length; p++){
            if(sArr[p] != '_') return false;
        }
        return true;
    }
}
