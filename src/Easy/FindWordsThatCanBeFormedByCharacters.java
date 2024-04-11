package Easy;

public class FindWordsThatCanBeFormedByCharacters {
        public int countCharacters(String[] words, String chars) {
            char[] arr = chars.toCharArray();
            int[] alphs = new int[26];
            int ans = 0;
            for (char c : arr) alphs[c - 'a']++;
            for (String s : words) {
                char[] arr2 = s.toCharArray();
                int[] alphs2 = new int[26];
                boolean isGood = true;
                for (char c : arr2) alphs2[c - 'a']++;
                for (int i = 0; i < 26; i++) {
                    if (alphs[i] < alphs2[i]) {
                        isGood = false;
                        break;
                    }
                }
                if (isGood) ans += s.length();
            }
            return ans;
        }
}
