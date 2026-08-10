class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Set<Integer> s = new HashSet<>();

        for(int num: map.values()){
            if(s.contains(num)) return false;
            s.add(num);
        }
        return true;
    }
}