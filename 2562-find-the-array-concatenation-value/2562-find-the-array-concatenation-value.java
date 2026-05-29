class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long concatenation = 0;
        int n = nums.length;
        for(int i =0; i< n/2; i++){
            int digit = 0;
            long val = nums[n-i-1];
            while(val> 0){
                val = val/10;
                digit++;
            }
            concatenation += nums[i]*Math.pow(10,digit) + nums[n-i-1];
        }
        if(n % 2 == 1) {
            concatenation += nums[n / 2];
        }
        return concatenation;
    }
}