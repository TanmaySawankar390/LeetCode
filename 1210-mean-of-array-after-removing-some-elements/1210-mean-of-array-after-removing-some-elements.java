import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int trimCount = n / 20;
        
        int sum = 0;
        for (int i = trimCount; i < n - trimCount; i++) {
            sum += arr[i];
        }
        
        return (double) sum / (n - 2 * trimCount);
    }
}