class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr,(a,b) -> Integer.compare(a[0], b[0]));

        long totalCost = 0;
        for(int[] x: arr) totalCost += x[1];

        long prefix = 0;
        int target = -1;

        for(int i = 0; i< n; i++){
            prefix += arr[i][1];
            if(prefix * 2 >= totalCost){
                target = arr[i][0];
                break;
            }
        }
        long ans = 0;
        for(int[] x: arr){
            ans += (long) Math.abs(x[0] - target) * x[1];
        }
        return ans;
    }
}