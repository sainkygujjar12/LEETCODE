class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1;
        if(k==1){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            for(Map.Entry<Integer,Integer> e:map.entrySet()){
                if(e.getValue()==1){
                    ans = Math.max(ans,e.getKey());
                }
            }
            return ans;
        }

        if(k==nums.length){
             int max = nums[0];
             for(int num:nums){
                max = Math.max(num,max);
             }
             return max;
        }
        else{
            boolean first = true;
            
            for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[0]){
                    first = false;
                }
            }
            if(first){
                ans = Math.max(ans,nums[0]);
            }
            boolean last = true;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==nums[nums.length-1]){
                    last = false;
                }
            }
            if(last){
                ans = Math.max(ans,nums[nums.length-1]);

            }
        }
        return ans;
    }
}