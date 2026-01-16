class Solution {
    public int robbHelper(int[] arr){
        int k = arr.length;
        int[] dp = new int[k];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int j = 2; j < k; j++){
            dp[j] = Math.max(dp[j-2]+arr[j],dp[j-1]);
        }
        return dp[k-1];
        }
    public int rob(int[] nums) {
        int n = nums.length;
        if( n < 2){
            return nums[0];
        }
        int[] skipLast = new int[n];
        int[] skipFirst = new int[n];

        for(int i = 0; i< n-1; i++){
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i+1];
        }

        int lootSkipLast = robbHelper(skipLast);
        int lootSkipFirst = robbHelper(skipFirst);

        return Math.max(lootSkipLast, lootSkipFirst);
    }
}