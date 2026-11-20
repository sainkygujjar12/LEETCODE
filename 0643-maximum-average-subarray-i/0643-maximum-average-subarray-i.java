class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        int win = k-1;
        int sum = 0;

        while(win>=0){
            sum+=nums[win--];
        }

         ans = (double) sum/k;
        for(int i=k;i<nums.length;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            ans = Math.max(ans,(double)sum/k);
        }
        return ans;
    }
}