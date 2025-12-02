public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remIndex = new HashMap<>();
        remIndex.put(0, -1);
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int r = (int)(total % k);
            if (remIndex.containsKey(r)) {
                if (i - remIndex.get(r) >= 2) return true;
            } else {
                remIndex.put(r, i);
            }
        }
        return false;
    }
}
