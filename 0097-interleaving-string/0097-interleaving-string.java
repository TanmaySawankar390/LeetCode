import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleaveHelper(s1, 0, s2, 0, s3, 0, new HashMap<>());
    }

    private boolean isInterleaveHelper(String s1, int i, String s2, int j, String s3, int k, Map<String, Boolean> memo) {
        if (k == s3.length()) return i == s1.length() && j == s2.length();

        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        boolean valid = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            valid = isInterleaveHelper(s1, i + 1, s2, j, s3, k + 1, memo);
        }
        if (!valid && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            valid = isInterleaveHelper(s1, i, s2, j + 1, s3, k + 1, memo);
        }

        memo.put(key, valid);
        return valid;
    }
}
