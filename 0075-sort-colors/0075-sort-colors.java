class Solution {
    public int[] swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

        return nums;
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high =nums.length-1;
        while(mid <= high){
            if(nums[mid]== 0){
                swap(nums, low, mid);
                mid++;
                low++;
            }else if(nums[mid]==2){
                swap(nums, mid, high);
                high--;
            }else {
                mid++;
            }
        }
        
    }
}