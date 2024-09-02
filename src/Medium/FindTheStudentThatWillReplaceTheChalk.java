package Medium;

public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        int[] prefix = new int[len];
        if(k < chalk[0]) return 0;
        prefix[0] = chalk[0];
        for(int i=1; i<len; i++){
            prefix[i] = prefix[i-1]+chalk[i];
            if(k < prefix[i]) return i;
        }
        k %= prefix[len-1];
        for(int i=0; i<len; i++){
            if(k < prefix[i]) return i;
        }
        return -1;
    }
}
