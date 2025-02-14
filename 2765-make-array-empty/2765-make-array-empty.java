import java.util.*;

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        long operations = n;

        TreeMap<Integer, Integer> sortedIndices = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            sortedIndices.put(nums[i], i);
        }
        
        List<Integer> sortedPositions = new ArrayList<>(sortedIndices.values());

        for (int i = 1; i < n; i++) {
            if (sortedPositions.get(i) < sortedPositions.get(i - 1)) {
                operations += (n - i);
            }
        }
        
        return operations;
    }
}
