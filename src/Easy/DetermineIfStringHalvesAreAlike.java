package Easy;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'a' ||  s.charAt(i) == 'e' ||  s.charAt(i) == 'i'
                    ||  s.charAt(i) == 'o' ||  s.charAt(i) == 'u'){
                if(i<n/2) count++;
                else count--;
            }
        }
        return count == 0;
    }
}
