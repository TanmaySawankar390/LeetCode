import java.util.Arrays;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        
        Arrays.sort(nums);
        
        for (int len = 1; len <= n / 2; len++) {
            if ((sum * len) % n != 0) continue;
            int target = (sum * len) / n;
            if (canFind(nums, 0, len, target)) return true;
        }
        
        return false;
    }
    
    private boolean canFind(int[] nums, int start, int k, int target) {
        if (k == 0) return target == 0;
        if (target < 0) return false;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            if (nums[i] > target) break;
            if (canFind(nums, i + 1, k - 1, target - nums[i])) return true;
        }
        return false;
    }
}
