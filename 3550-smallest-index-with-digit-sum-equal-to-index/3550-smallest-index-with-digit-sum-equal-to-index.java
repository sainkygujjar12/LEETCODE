class Solution {
    public boolean sumOfdigit(int num, int ind){
        int res = 0;

        while(num>0){
            int digit = num%10;
            res+=digit;
            num/=10;
        }

        return ind==res;
    }
    public int smallestIndex(int[] nums) {
        int ans = -1;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(sumOfdigit(num,i)){
                ans = i;
                break;
            }
        }
        return ans;
    }
}