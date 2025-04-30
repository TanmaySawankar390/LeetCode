class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        int totalSteps = m + n - 2;
        int downSteps = Math.min(m - 1, n - 1);

        for (int i = 1; i <= downSteps; i++) {
            res = res * (totalSteps - downSteps + i) / i;
        }

        return (int) res;
    }
}
