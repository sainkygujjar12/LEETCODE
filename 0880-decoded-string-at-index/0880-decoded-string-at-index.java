class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)) size *= (c - '0');
            else size++;
        }

        for(int i=s.length()-1;i>=0;i--){
            k%=size;

            if(k==0 && !Character.isDigit(s.charAt(i))){
                 return "" + s.charAt(i);
            }else if(Character.isDigit(s.charAt(i))){
                size/= (s.charAt(i)-'0');
            }else size--;
        }
        return "";
    }
}