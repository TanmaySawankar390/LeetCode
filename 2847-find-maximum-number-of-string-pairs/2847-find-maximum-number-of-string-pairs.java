class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int pairs = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isReverse(words[i], words[j])) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    private boolean isReverse(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int n = a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
