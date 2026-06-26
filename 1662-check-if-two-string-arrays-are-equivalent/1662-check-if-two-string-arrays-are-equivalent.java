class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int pos1 = 0;
        int pos2 = 0;

        while(i<word1.length && j<word2.length){
            if(word1[i].charAt(pos1)!=word2[j].charAt(pos2)) return false;
            pos1++;
            pos2++;

            if(pos1==word1[i].length()){
                i++;
                pos1=0;
            }

            if(pos2==word2[j].length()){
                j++;
                pos2=0;
            }
        }

        return i==word1.length && j==word2.length;
    }
}