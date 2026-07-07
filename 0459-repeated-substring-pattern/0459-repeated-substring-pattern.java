class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        

        int start = n/2;

        for(int i=start;i>=1;i--){
            if(n%i==0){
                StringBuilder sb = new StringBuilder();
                String pattern = s.substring(0,i);

                int time = n/i;
                while(time-->0){
                    sb.append(pattern);
                }

                if(s.equals(sb.toString())) return true;
            }

        }
        return false;
    }
}