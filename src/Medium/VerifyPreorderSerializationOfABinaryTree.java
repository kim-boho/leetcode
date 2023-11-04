package Medium;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")) return true;
        String[] sArr = preorder.split(",");
        if(sArr[0].equals("#")) return false;
        int legs = 2;
        int i = 1;
        while(i<sArr.length){
            if(legs == 0) return false;
            if(!sArr[i++].equals("#")) legs++;
            else legs--;
        }
        return legs == 0;
    }

}
