class Solution {
    public void rotate(int[] nums, int k) {

        k = k% nums.length;

        if(nums.length < 2){
            System.out.println(Arrays.toString(nums));
            return;
        }
        // reverse ka funcion likho
        reverse(nums,0,nums.length-1);

        reverse(nums,0,k-1);

        reverse(nums,k,nums.length-1);
        // then rotate k alag se and then baaki bache fir alag se rotate
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}