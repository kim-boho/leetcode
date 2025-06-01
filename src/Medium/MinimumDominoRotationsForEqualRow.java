package Medium;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = tops.length;
        int t = tops[0];
        int b = bottoms[0];

        int count = 0;
        for(int i=1; i<tops.length; i++){
            if(tops[i] == t) continue;
            else if(bottoms[i] == t) count++;
            else{
                count = -1;
                break;
            }
        }
        int count2 = t != b? 1:0;
        for(int i=1; i<tops.length; i++){
            if(tops[i] == b) continue;
            else if(bottoms[i] == b) count2++;
            else{
                count2 = -1;
                break;
            }
        }

        int result1 = 0;
        if(count == -1 && count2 == -1) result1 = -1;
        else if(count ==-1) result1 = count2;
        else result1 = count;

        count = t != b? 1:0;
        for(int i=1; i<tops.length; i++){
            if(bottoms[i] == t) continue;
            else if(tops[i] == t) count++;
            else{
                count = -1;
                break;
            }
        }
        count2 = 0;
        for(int i=1; i<tops.length; i++){
            if(bottoms[i] == b) continue;
            else if(tops[i] == b) count2++;
            else{
                count2 = -1;
                break;
            }
        }
        int result2 = 0;
        if(count == -1 && count2 == -1) result2 = -1;
        else if(count ==-1) result2 = count2;
        else result2 = count;

        if(result1+result2 == -2) return -1;
        else if(result1 == -1) return result2;
        else if(result2 == -1) return result1;
        else return Math.min(result1,result2);
    }
}
