class Solution {
    public boolean backspaceCompare(String s, String t) {
        int stepS = 0;
        int stepT = 0;
        int i = s.length()-1;
        int j = t.length()-1;

        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    stepS++;
                    i--;
                }else if(stepS>0){
                    stepS--;
                    i--;
                }else{
                    break;
                }
            }

            while(j>=0){
                if(t.charAt(j)=='#'){
                    stepT++;
                    j--;
                }else if(stepT>0){
                    stepT--;
                    j--;
                }else{
                    break;
                }
            }

            char first = (i < 0) ? '$' : s.charAt(i);
            char second = (j < 0) ? '$' : t.charAt(j);

            if(first!=second) return false;

            i--;
            j--;

        
        }
        return true;
    }
}