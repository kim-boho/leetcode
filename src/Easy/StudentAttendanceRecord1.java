package Easy;

public class StudentAttendanceRecord1 {
    public boolean checkRecord(String s) {
        char[] charArr = s.toCharArray();
        int a = 0;
        for(int i=0; i<charArr.length; i++){
            if(charArr[i] == 'A'){
                a++;
                if(a == 2) return false;
            } else if(charArr[i] == 'L'){
                if(i+2 < charArr.length && charArr[i+1] == 'L' && charArr[i+2] == 'L') return false;
            }
        }
        return true;
    }
}
