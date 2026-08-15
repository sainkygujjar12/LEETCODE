class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean nonZero = false;
        int xor = 0;

        for(int num :nums){
            xor^=num;
            if(num!=0){
                nonZero = true;
            }

        }

        if(xor!=0) return n;
        else if(xor==0 && nonZero) return n-1;
        else return 0;
    }
}