package Easy;

public class Base7 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isPos = num>=0? true:false;
        num = Math.abs(num);
        while(num >= 7){
            sb.append(num % 7);
            num = num/7;
        }
        sb.append(num);
        return isPos? sb.reverse().toString():"-"+sb.reverse().toString();
    }
}
