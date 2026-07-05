class Solution {
    public boolean dfs(String word,Set<String> set,Map<String, Boolean> map){
        if(map.containsKey(word)) return map.get(word);

        int n = word.length();

        for(int i=0;i<n;i++){
            String pre = word.substring(0,i+1);
            String suff = word.substring(i+1);

            if(set.contains(pre) && (set.contains(suff)||dfs(suff,set,map))){
                map.put(word,true);
                return true;
            }
        }
        map.put(word,false);
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        Map<String,Boolean> map = new HashMap<>();

        for(String word:words){
            for(int i=0;i<word.length();i++){
                String pre = word.substring(0,i);
                String suff = word.substring(i);
                if(!set.contains(pre)) continue;
                if(set.contains(suff) || dfs(suff,set,map)){
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }
}