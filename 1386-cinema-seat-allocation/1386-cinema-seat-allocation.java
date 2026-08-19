class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Set<Integer>> map= new HashMap<>();

        for(int r[]:reservedSeats){
            int row= r[0];
            int c = r[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(c);
        }

        int ans = (n-map.size()) * 2;
        for(Set<Integer> s : map.values()){
            boolean left = true;
            boolean right = true;
            boolean middle = true;

            for(int i=2;i<=5;i++){
                if(s.contains(i)){
                    left = false;
                    break;
                }
            }
            for(int i=4;i<=7;i++){
                if(s.contains(i)){
                    middle = false;
                    break;
                }
            }
            for(int i=6;i<=9;i++){
                if(s.contains(i)){
                    right = false;
                    break;
                }
            }

            if(left && right){
                ans+=2;
            }
            else if(left||right||middle){
                ans+=1;
            }
        }
        return ans;
    }
}