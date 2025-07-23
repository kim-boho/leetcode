package Medium;

public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        if(s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        char fir = x > y? 'a':'b';
        char sec = fir == 'a'? 'b':'a';
        int p1 = Math.max(x,y);
        int p2 = Math.min(x,y);
        int total = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] <= 'b'){
                int spareSec = 0;
                int firCount = 0;
                int pointCount = 0;
                int j;
                for(j=i; j<chars.length && chars[j] <= 'b'; j++){
                    if(chars[j] == fir) firCount++;
                    else{
                        if(firCount > 0){
                            pointCount++;
                            firCount--;
                        } else spareSec++;
                    }
                }
                total += pointCount*p1;
                total += Math.min(spareSec,firCount)*p2;
                i = j;
            }
        }
        return total;
    }
}
