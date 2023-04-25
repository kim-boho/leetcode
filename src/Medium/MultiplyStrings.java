package Medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] numArr = new int[num1.length()+num2.length()];
        int index = numArr.length - 1;
        for(int i=num1.length()-1; i>=0; i--){
            int overTen = 0;
            int tempIndex = index;
            for(int j = num2.length()-1; j>=0; j--){
                int multiple = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int totalSum = numArr[index] + multiple + overTen;
                numArr[index] = totalSum % 10;
                overTen = totalSum / 10;
                index--;
            }
            if(overTen != 0) numArr[index] += overTen;
            index = tempIndex-1;
        }

        StringBuilder sb = new StringBuilder("");
        int numIndex = 0;
        while(numIndex<numArr.length && numArr[numIndex] == 0) numIndex++;
        for(int i=numIndex; i<numArr.length; i++) sb.append(numArr[i]);
        return sb.toString().length() == 0? "0":sb.toString();
    }
}
