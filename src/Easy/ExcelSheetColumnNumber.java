package Easy;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int len = columnTitle.length();
        for(int i=0; i<len; i++){
            ans += (columnTitle.charAt(i)-'A'+1)*Math.pow(26, len-i-1);
        }
        return ans;
    }
}
