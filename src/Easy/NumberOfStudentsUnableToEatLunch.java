package Easy;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int i = 0;
        int total = students.length;
        while(true){
            int count = 0;
            for(int j=0; j<students.length; j++){
                if(sandwiches[i] == students[j]){
                    count++;
                    total--;
                    students[j] = -1;
                    i++;
                }
                if(total == 0) break;
            }
            if(count == 0 || total == 0) break;
        }
        return total;
    }
}
