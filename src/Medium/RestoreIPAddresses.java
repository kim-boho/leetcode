package Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        char[] sArr = s.toCharArray();
        List<String> ans = new ArrayList<>();
        String[] tempNums = new String[4];
        makeNum(0,sArr,ans,0,tempNums);
        return ans;
    }

    private void makeNum(int start, char[] sArr, List<String> ans, int count, String[] tempNums){
        if(start >= sArr.length){
            if(count == 4){
                StringBuilder sb = new StringBuilder();
                sb.append(tempNums[0]);
                for(int i=1; i<tempNums.length; i++){
                    sb.append('.');
                    sb.append(tempNums[i]);
                }
                ans.add(sb.toString());
            }
            return;
        }
        if(count == 4) return;
        StringBuilder sb = new StringBuilder();
        sb.append(sArr[start]);
        tempNums[count] = sb.toString();
        makeNum(start+1,sArr,ans,count+1,tempNums);
        if(start+1 >= sArr.length) return;
        sb.append(sArr[start+1]);
        if(Integer.parseInt(sb.toString()) >= 10){
            tempNums[count] = sb.toString();
            makeNum(start+2,sArr,ans,count+1,tempNums);
        } else return;
        if(start+2 >= sArr.length) return;
        sb.append(sArr[start+2]);
        if(Integer.parseInt(sb.toString()) <= 255){
            tempNums[count] = sb.toString();
            makeNum(start+3,sArr,ans,count+1,tempNums);
        }
    }
}
