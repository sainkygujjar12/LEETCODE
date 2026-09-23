class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int num:nums){
            totalSum+=num;
        }
        int target = totalSum - x;
        int left = 0;
        int maxLen = -1;
        int sum = 0;

        if(target==0) return nums.length;

        for(int right =0;right<nums.length;right++){
            sum+=nums[right];

            while(left<=right && sum>target){
                sum-=nums[left++];
            }

            if(sum==target){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }

        return maxLen==-1?-1:nums.length-maxLen;
    }
}