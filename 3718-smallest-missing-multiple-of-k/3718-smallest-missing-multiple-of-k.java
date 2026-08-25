class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        boolean arr[] = new boolean[101];
        int newNum = k;
        
        for(int num:nums){
            arr[num] = true;
        }

        while(newNum<=100){
            if(!arr[newNum]) return newNum;
            newNum+=k;
        }
        return newNum;

    }
}