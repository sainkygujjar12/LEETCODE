class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        int ans = 0;

        for(int r=0;r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while(map.get(nums[r])>k){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}