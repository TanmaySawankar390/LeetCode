class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            if ((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            if ((long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                if ((long)nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
                if ((long)nums[i] + nums[j] + nums[n-1] + nums[n-2] < target) continue;
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                
                int lo = j + 1, hi = n - 1;
                long need = (long)target - nums[i] - nums[j];
                
                while (lo < hi) {
                    long sum2 = nums[lo] + nums[hi];
                    if (sum2 == need) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; 
                        hi--;
                    } else if (sum2 < need) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        
        return ans;
    }
}
