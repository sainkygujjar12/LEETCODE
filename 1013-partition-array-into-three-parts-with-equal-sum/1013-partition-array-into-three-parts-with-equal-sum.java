class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum = 0;
        for(int num:arr) sum+=num;
        if(sum%3!=0) return false;
        int part = 0;
        int target = sum/3;
        sum = 0;
        for(int num:arr){
            sum+=num;
            if(sum==target){
                sum = 0;
                part++;
            }
        }
        return part>=3;
    }
}