class Solution {
    public int majorityElement(int[] nums) {
        int cand = nums[0];
        int count = 1;

        for(int i =1;i<nums.length;i++){
            if(count<=0){
                cand = nums[i];
                count = 1;
            }
            else if(nums[i]==cand) count++;
            else count--;
        }
        return cand;
    }
}