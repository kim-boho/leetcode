public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        char[] arr = word.toCharArray();
        boolean isLower = Character.isLowerCase(arr[1]);
        if(Character.isLowerCase(arr[0]) && !isLower) return false;
        for(int i=2; i<arr.length; i++){
            if(isLower){
                if(Character.isUpperCase(arr[i])) return false;
            } else{
                if(Character.isLowerCase(arr[i])) return false;
            }
        }
        return true;
    }
}
