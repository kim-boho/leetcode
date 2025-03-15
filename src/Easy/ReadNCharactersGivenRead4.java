package Easy;

public class ReadNCharactersGivenRead4 {
    int read4(char[] buf4){
        return buf4.length;
    }
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int j = 0;
        while(n > 0){
            int m = read4(buf4);
            for(int i=0; i<Math.min(n,m); i++) buf[j++] = buf4[i];
            n -= 4;
        }
        return j;
    }
}
