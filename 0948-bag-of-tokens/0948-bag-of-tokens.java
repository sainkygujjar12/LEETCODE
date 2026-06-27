class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;

        while(i<=j){
            if(tokens[i]<=power){
                score++;
                power-=tokens[i];
                i++;
            }else if(i<j && score>0){
                score--;
                power+=tokens[j--];
            }else return score;
        }
        return score;
    }
}