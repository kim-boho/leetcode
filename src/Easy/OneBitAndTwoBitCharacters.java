package Easy;

public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0; i<bits.length; i++){
            if(i == bits.length-1) return true;
            if(bits[i] == 0) continue;
            else i++;
        }
        return false;
    }

}
