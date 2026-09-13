class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum =0;

        // total sum
        for(int num:nums){
            totalSum+=num;
        }

        int prefixSum = 0;

        for(int i=0;i<nums.length;i++){
            int rightSum = totalSum-prefixSum-nums[i];

            if(prefixSum==rightSum){
                return i;
            }

            prefixSum+=nums[i];
        }

        return -1;

    }
}