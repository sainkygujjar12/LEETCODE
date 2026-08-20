class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        int first = 0;
        int second = 0;
        arr1[first++] = nums[0];
        arr2[second++] = nums[1];

        for(int i=2;i<n;i++){
            if(arr1[first-1]>arr2[second-1]){
                arr1[first++] = nums[i];
            }else {
                arr2[second++] = nums[i];
            }
        }
        int res[] = new int[n];
        int i=0;
        for(int k=0;k<first;k++){
            res[i++] = arr1[k];
        }
        for(int j = 0;j<second;j++){
            res[i++] = arr2[j];
        }
        return res;

    }
}