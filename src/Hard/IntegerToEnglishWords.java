package Hard;

import java.util.HashMap;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        HashMap<Integer, String> hm = new HashMap();
        hm.put(1, "One");
        hm.put(2, "Two");
        hm.put(3, "Three");
        hm.put(4, "Four");
        hm.put(5, "Five");
        hm.put(6, "Six");
        hm.put(7, "Seven");
        hm.put(8, "Eight");
        hm.put(9, "Nine");
        hm.put(10, "Ten");
        hm.put(11, "Eleven");
        hm.put(12, "Twelve");
        hm.put(13, "Thirteen");
        hm.put(14, "Fourteen");
        hm.put(15, "Fifteen");
        hm.put(16, "Sixteen");
        hm.put(17, "Seventeen");
        hm.put(18, "Eighteen");
        hm.put(19, "Nineteen");
        hm.put(20, "Twenty");
        hm.put(30, "Thirty");
        hm.put(40, "Forty");
        hm.put(50, "Fifty");
        hm.put(60, "Sixty");
        hm.put(70, "Seventy");
        hm.put(80, "Eighty");
        hm.put(90, "Ninety");

        StringBuilder sb = new StringBuilder("");

        if(num >= 1000_000_000){
            int target = num / 1000_000_000;
            if(target != 0) sb.append(hm.get(target)+" Billion ");
        }

        num %= 1000_000_000;

        if(num >= 1000_000){
            int target = num / 1000_000;
            addNums(target, sb, "Million", hm);
        }

        num %= 1000_000;

        if(num >= 1000){
            int target = num / 1000;
            addNums(target, sb, "Thousand", hm);
        }

        num %= 1000;

        if(num >= 1) addNums(num, sb, "", hm);

        return sb.toString().replace("  "," ").trim();

    }

    private void addNums(int target, StringBuilder sb, String pos, HashMap<Integer, String> hm){
        if(target != 0){
            if(target >= 100){
                int firNum = target / 100;
                sb.append(hm.get(firNum)+" Hundred ");
            }

            target %= 100;

            if(target < 10 && target != 0){
                sb.append(hm.get(target));
            } else if(target != 0){
                if(target % 10 == 0 || (target>=11 && target<=19)) sb.append(hm.get(target));
                else{
                    int sec = target % 10;
                    int fir = target - sec;
                    sb.append(hm.get(fir)+" "+hm.get(sec));
                }
            }

            sb.append(" "+pos+" ");
        }
    }
}
