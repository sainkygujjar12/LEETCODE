class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = nums[n-1];
        int p2 = nums[n-2];

        return (p1-1)*(p2-1);
    }
}