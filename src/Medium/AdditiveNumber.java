package Medium;

import java.util.ArrayList;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if(num.equals("000") || num.equals("0000")) return true;
        for(int i=1; i<num.length(); i++){
            if(i+1<num.length() && num.charAt(i+1) != '0'){
                ArrayList<long[]> twoNumList = makeNumber(0,i,num);
                for(int j=0; j<twoNumList.size(); j++){
                    long fir = twoNumList.get(j)[0];
                    long sec = twoNumList.get(j)[1];
                    if(i+1 < num.length()){
                        if(dfs(fir, sec, i+1, num)) return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(long first, long second, int start, String num){
        if(start == num.length()) return true;
        long sum = first+second;
        int count = start;
        while(sum > 0){
            count++;
            sum /= 10;
        }
        if(count <= num.length()){
            long nextNum = Long.valueOf(num.substring(start, count));
            if(nextNum == first+second){
                return dfs(second, nextNum, count, num);
            } else{
                return false;
            }
        } else{
            return false;
        }

    }

    private ArrayList<long[]> makeNumber(int start, int end, String num){
        ArrayList<long[]> ans = new ArrayList();
        if(num.charAt(start) == '0'){
            long second = Long.valueOf(num.substring(1,end+1));
            long[] arr = {0, second};
            ans.add(arr);
            return ans;
        }
        int mid = start+1;
        while(mid<=end){
            long first = Long.valueOf(num.substring(start,mid));
            if(num.charAt(mid) == '0'){
                if(mid != end){
                    mid++;
                    continue;
                }
            }
            long second = Long.valueOf(num.substring(mid,end+1));
            long[] arr = {first, second};
            ans.add(arr);
            mid++;
        }
        return ans;
    }
}
