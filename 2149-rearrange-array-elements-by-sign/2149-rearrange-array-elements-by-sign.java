class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos =0;
        int neg = 1;
        int ans[] = new int[nums.length];


        for(int num:nums){
            if(num>0){
                ans[pos] = num;
                pos+=2;
            }else{
                ans[neg] = num;
                neg+=2;
            }
        }
        return ans;
    }
}