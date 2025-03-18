class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }
        
        long gain = 0, loss = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            long diff = nums1[i] - nums2[i];
            if (diff > 0) {
                if (diff % k != 0) return -1;
                gain += diff;
            } else if (diff < 0) {
                if (-diff % k != 0) return -1;
                loss += -diff;
            }
        }

        if (gain != loss) return -1;

        return gain / k;
    }
}
