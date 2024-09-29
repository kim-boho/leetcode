package Easy;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-","");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if(s.length() % k != 0){
            sb.append(s.substring(0,s.length() % k).toUpperCase());
            i = s.length() % k;
        }
        for(;i<s.length(); i+=k){
            if(i != 0){
                sb.append('-');
            }
            sb.append(s.substring(i,i+k).toUpperCase());
        }
        return sb.toString();
    }
}
