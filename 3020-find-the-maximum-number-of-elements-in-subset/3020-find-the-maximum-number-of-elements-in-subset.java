class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> map = new HashMap<>();
        int one = 0;

        int ans = 0;
        for(int num : nums){
            if(num == 1) one++;
            map.put((long)num,map.getOrDefault((long) num,0)+1);
        }
        if(one%2 == 0) ans = one-1;
        else ans = one;

        for(long num :map.keySet()){
            int len = 0;
            long curr = num;

            if(num == 1) continue;

            while(map.getOrDefault(curr,0)>=2){
                len+=2;
                curr*=curr;
            }
            if(map.getOrDefault(curr,0)>=1) len+=1;
            else len-=1;

            ans = Math.max(len,ans);
        }

        return ans;
    }
}