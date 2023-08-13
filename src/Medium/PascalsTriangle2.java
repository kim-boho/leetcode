package Medium;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=1; i<=rowIndex; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=0; j<ans.size()-1; j++){
                temp.add(ans.get(j)+ans.get(j+1));
            }
            temp.add(1);
            ans = temp;
        }
        return ans;
    }
}
