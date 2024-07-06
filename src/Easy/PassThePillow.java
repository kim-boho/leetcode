package Easy;

public class PassThePillow {
    public int passThePillow(int n, int time) {
        return time % ((n-1)*2) > (n-1) ? 2*(n-1) - time % ((n-1)*2)+1 : time % ((n-1)*2)+1;
    }
}
