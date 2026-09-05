class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> cand = new ArrayList<>();
        int maxCount = 0;
        for(int num:candies){
            maxCount = Math.max(maxCount,num);
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=maxCount){
                cand.add(true);
            }else cand.add(false);
        }
        return cand;
    }
}