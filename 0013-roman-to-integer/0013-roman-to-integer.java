class Solution {
    public static int getValue(char roman) {
        if (roman == 'I') return 1;
        if (roman == 'V') return 5;
        if (roman == 'X') return 10;
        if (roman == 'L') return 50;
        if (roman == 'C') return 100;
        if (roman == 'D') return 500;
        if (roman == 'M') return 1000;
        return 0;
    }

    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = getValue(s.charAt(i));

            if (i < n - 1 && current < getValue(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}