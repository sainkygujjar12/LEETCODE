class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> inactive = new ArrayList<>();

        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
        }

        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)=='0'){
                int start = i;
                while(i<s.length() && s.charAt(i)=='0') i++;
                inactive.add(i-start);
            }else i++;
        }

        int max = 0;

        for(int j=1;j<inactive.size();j++){
            max = Math.max(max,inactive.get(j)+inactive.get(j-1));
        }
        return max+count;
    }
}