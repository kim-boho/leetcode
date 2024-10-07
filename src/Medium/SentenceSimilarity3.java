package Medium;

public class SentenceSimilarity3 {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.equals(s2)) return true;
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        int i = 0;
        while(i<Math.min(arr1.length, arr2.length) && arr1[i].equals(arr2[i])) i++;
        if(i == Math.min(arr1.length, arr2.length)) return true;
        int j = arr1.length-1;
        int k = arr2.length-1;
        while(j >= 0 && k >= 0 && arr1[j].equals(arr2[k])){
            j--;
            k--;
        }
        return j < i || k < i;
    }
}
