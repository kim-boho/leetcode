package Easy;

public class SimilarRGBColor {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        char[] hexas = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        char[] colorChar = color.toCharArray();
        for(int i=1; i<colorChar.length; i+=2){
            int currentColor = 16*convertNum(colorChar[i])+convertNum(colorChar[i+1]);
            int gap = currentColor*currentColor;
            int idx = 0;
            for(int j=1; j<16; j++){
                int tempNum = j+j*16;
                if((currentColor-tempNum)*(currentColor-tempNum) < gap){
                    gap = (currentColor-tempNum)*(currentColor-tempNum);
                    idx = j;
                } else break;
            }
            sb.append(hexas[idx]);
            sb.append(hexas[idx]);
        }
        return sb.toString();
    }

    private int convertNum(char c){
        if(c >= '0' && c <= '9') return c-'0';
        else return 10+(c-'a');
    }
}
