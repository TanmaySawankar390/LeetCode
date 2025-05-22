import java.util.Random;

class Solution {
    private final int[] original;
    private final Random rand;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.rand = new Random();
    }
    public int[] reset() {
        return original.clone();
    }
    public int[] shuffle() {
        int[] a = original.clone();
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }
}
