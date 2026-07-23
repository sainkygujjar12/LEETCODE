class Solution {
    public int takeCharacters(String s, int k) {
        int countA = 0;
        int countB = 0;
        int countC = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') countA++;
            else if(s.charAt(i)=='b') countB++;
            else countC++;
        }

        if(countA<k||countB<k||countC<k) return -1;
        int count[] = new int[3];
        count[0] = countA;
        count[1] = countB;
        count[2] = countC;

        int maxL = 0;
        int l = 0;

       for(int i = 0;i<s.length();i++){
            count[s.charAt(i)-'a']--;

            while(count[0]<k||count[1]<k||count[2]<k){
                count[s.charAt(l)-'a']++;
                l++;
            }
            maxL = Math.max(maxL,i-l+1);
       }
       return s.length()-maxL;
    }
}