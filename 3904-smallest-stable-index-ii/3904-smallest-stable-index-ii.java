class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minArr = new int[n];
        int minEl = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            minArr[i] = Math.min(nums[i],minEl);
            minEl = Math.min(nums[i],minEl);
        }

        int maxEl = -1;
        for(int i=0;i<n;i++){
            maxEl = Math.max(maxEl,nums[i]);
            if(maxEl-minArr[i]<=k) return i;
        }
        return -1;
    }
}