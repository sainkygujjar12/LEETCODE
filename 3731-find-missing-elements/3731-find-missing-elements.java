class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        ArrayList<Integer> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            mx = Math.max(num,mx);
            mn = Math.min(num,mn);
        }

        for(int i=mn+1;i<mx;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}