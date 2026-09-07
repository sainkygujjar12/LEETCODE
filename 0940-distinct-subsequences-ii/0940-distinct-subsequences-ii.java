class Solution {
    public int distinctSubseqII(String s) {
  int mod=1000000007;
    long[]cnt=new long[26];
     long sum=0;
    for(char c:s.toCharArray()){
    long total=(1+sum)%mod;
    sum=sum+(total-cnt[c-'a']);
  cnt[c-'a']=total;
    }
        return (int)(sum%mod);
    }
}