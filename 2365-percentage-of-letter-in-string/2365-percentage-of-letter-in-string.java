class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        int length = s.length();
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return (count * 100) / length;
    }
}
