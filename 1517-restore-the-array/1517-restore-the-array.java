class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            long num = 0;
            for (int j = i; j > 0 && (i - j + 1) <= 10; j--) {
                num = Long.parseLong(s.substring(j - 1, i)); 
                if (s.charAt(j - 1) == '0') continue;
                if (num > k) break;
                
                dp[i] = (dp[i] + dp[j - 1]) % MOD;
            }
        }
        
        return dp[n];
    }
}
