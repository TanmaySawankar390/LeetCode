import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        int largestLucky = -1;
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                largestLucky = Math.max(largestLucky, entry.getKey());
            }
        }
        
        return largestLucky;
    }
}
