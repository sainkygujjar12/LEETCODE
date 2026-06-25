class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0 ;

        map.put(0,1);
        int ans =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int key = sum-k;
            if(map.containsKey(key)){
                ans+=map.get(key);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}