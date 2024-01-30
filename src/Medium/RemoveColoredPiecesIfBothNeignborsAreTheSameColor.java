package Medium;

public class RemoveColoredPiecesIfBothNeignborsAreTheSameColor {
    public boolean winnerOfGame(String colors) {
        char[] charArr = colors.toCharArray();
        int a = 0;
        for(int i=1; i<charArr.length; i++){
            if(charArr[i-1] == charArr[i]){
                char c = charArr[i];
                i++;
                int count = 0;
                while(i < charArr.length && charArr[i] == c){
                    count++;
                    i++;
                }
                if(c == 'A') a+=count;
                else a-=count;
                i--;
            }
        }
        return a > 0;
    }
}
