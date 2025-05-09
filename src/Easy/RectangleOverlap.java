package Easy;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0] <= rec2[0]){
            if(rec2[0] >= rec1[2]) return false;
        } else{
            if(rec1[0] >= rec2[2]) return false;
        }

        if(rec1[1] <= rec2[1]){
            if(rec1[3] <= rec2[1]) return false;
        } else{
            if(rec2[3] <= rec1[1]) return false;
        }
        return true;
    }
}
