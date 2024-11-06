package Medium;

import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(secondList.length == 0 || firstList.length == 0) return new int[0][0];
        int start = Math.min(firstList[0][0],secondList[0][0]);
        int i = 0;
        int j = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            if(firstList[i][1] <= secondList[j][0]){
                if(firstList[i][1] == secondList[j][0]){
                    int[] temp = new int[]{firstList[i][1],firstList[i][1]};
                    ans.add(temp);
                }
                i++;
            } else if(secondList[j][1] <= firstList[i][0]){
                if(secondList[j][1] == firstList[i][0]){
                    int[] temp = new int[]{secondList[j][1],secondList[j][1]};
                    ans.add(temp);
                }
                j++;
            } else {
                int[] temp = new int[]{Math.max(firstList[i][0],secondList[j][0]),Math.min(firstList[i][1],secondList[j][1])};
                ans.add(temp);
                if(firstList[i][1] <= secondList[j][1]) i++;
                else j++;
            }
        }
        int[][] ansArr = new int[ans.size()][2];
        for(int k=0; k<ansArr.length; k++){
            ansArr[k] = ans.get(k);
        }
        return ansArr;
    }
}
