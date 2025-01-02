package Medium;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        else{
            int sLen = s.length();
            int tLen = t.length();
            int sIdx = 0;
            int tIdx = 0;
            int diffCount = 0;
            char[] sCharArr = s.toCharArray();
            char[] tCharArr = t.toCharArray();
            if(sLen == tLen){
                while(sIdx < sLen){
                    if(sCharArr[sIdx++] != tCharArr[tIdx++]){
                        diffCount++;
                        if(diffCount > 1) return false;
                    }
                }
                return true;
            } else if(sLen-1 == tLen){
                while(sIdx < sLen && tIdx < tLen){
                    if(sCharArr[sIdx] != tCharArr[tIdx]){
                        diffCount++;
                        sIdx++;
                        if(diffCount > 1) return false;
                    } else{
                        sIdx++;
                        tIdx++;
                    }
                }
                if(diffCount == 0 && sIdx == sLen-1 && tIdx == tLen) return true;
                else if(diffCount == 1 && sIdx == sLen && tIdx == tLen) return true;
                else return false;
            } else if(sLen+1 == tLen){
                while(sIdx < sLen && tIdx < tLen){
                    if(sCharArr[sIdx] != tCharArr[tIdx]){
                        diffCount++;
                        tIdx++;
                        if(diffCount > 1) return false;
                    } else{
                        sIdx++;
                        tIdx++;
                    }
                }
                if(diffCount == 0 && sIdx == sLen && tIdx == tLen-1) return true;
                else if(diffCount == 1 && sIdx == sLen && tIdx == tLen) return true;
                else return false;
            } else return false;
        }
    }
}
