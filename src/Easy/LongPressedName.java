package Easy;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char[] arr = name.toCharArray();
        char[] arr2 = typed.toCharArray();
        int i = 0;
        int j = 0;
        while(i < arr.length){
            int count = 1;
            char c = arr[i];
            i++;
            while(i < arr.length && arr[i] == c){
                i++;
                count++;
            }
            int count2 = 0;
            while(j < arr2.length && arr2[j] == c){
                j++;
                count2++;
            }
            if(count > count2) return false;
        }
        if(j != arr2.length) return false;
        return true;
    }
}
