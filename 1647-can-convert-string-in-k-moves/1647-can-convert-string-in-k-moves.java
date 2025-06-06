class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] shiftCounts = new int[26];
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (shift > 0) {
                shiftCounts[shift]++;
                int maxRequiredMoves = shift + (shiftCounts[shift] - 1) * 26;
                if (maxRequiredMoves > k) {
                    return false;
                }
            }
        }
        
        return true;
    }
}