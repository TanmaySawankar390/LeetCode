class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefixSum = 0;
        int maxVal = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int avgCeil = (int) Math.ceil((double) prefixSum / (i + 1));
            maxVal = Math.max(maxVal, avgCeil);
        }
        
        return maxVal;
    }
}
