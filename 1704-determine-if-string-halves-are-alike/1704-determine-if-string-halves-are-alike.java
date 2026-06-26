class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0;i<n;i++){
            if(i<n/2){
                char c = s.charAt(i);
                c = Character.toLowerCase(c);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') count++;
            }else{
                char c = s.charAt(i);
                c = Character.toLowerCase(c);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') count--;
            }
        }
        return count==0;
    }
}