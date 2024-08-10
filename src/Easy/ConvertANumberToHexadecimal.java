package Easy;

import java.util.ArrayList;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0) return "0";
        if(num == -2147483648) return "80000000";
        ArrayList<Character> li = new ArrayList<>();
        int n  = Math.abs(num);
        int div = 16;
        if(num < 0){
            div = 2;
        }
        char[] rems = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(n > 0){
            li.add(rems[n % div]);
            n = n / div;
        }
        if(num < 0){
            for(int i=0; i<32; i++){
                if(i<li.size()){
                    if(li.get(i) == '0') li.set(i,'1');
                    else li.set(i,'0');
                } else{
                    li.add('1');
                }
            }
            for(int i=0; i<li.size(); i++){
                if(li.get(i) == '0'){
                    li.set(i,'1');
                    break;
                } else li.set(i,'0');
            }
            ArrayList<Character> temp = new ArrayList<>();
            for(int i=0; i<li.size(); i += 4){
                int hex = 0;
                int times = 1;
                for(int j=i; j<i+4; j++){
                    hex += times*(li.get(j)-'0');
                    times *= 2;
                }
                temp.add(rems[hex]);
            }
            li = temp;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<li.size(); i++){
            ans.append(li.get(i));
        }
        return ans.reverse().toString();
    }
}
