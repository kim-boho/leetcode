package Medium;

public class LastMomentBeforeAllAntsFallOutOfAPlank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMin = n+1;
        for(int i:right) leftMin = Math.min(i,leftMin);
        int rightMax = 0;
        for(int i:left) rightMax = Math.max(i,rightMax);
        return Math.max(rightMax,n-leftMin);
    }
}
