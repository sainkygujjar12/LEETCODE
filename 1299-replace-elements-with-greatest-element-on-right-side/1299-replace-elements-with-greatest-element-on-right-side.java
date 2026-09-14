class Solution {
    public int[] replaceElements(int[] arr) {
        int res[] = new int[arr.length];
        int n = arr.length;
        if(n==1){
            return new int[]{-1};
        }
        res[n-1]=-1;
        res[n-2]=arr[n-1];

        int max = Math.max(arr[n-2],res[n-2]);
        for(int i=n-3;i>=0;i--){
            res[i] = max;
            max = Math.max(res[i],arr[i]);
        }
        return res;
    }
}