class LRUCache {
    int capacity;
    LinkedList<Integer> list;
    HashMap<Integer,Integer> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        list.remove(Integer.valueOf(key));  
        list.addFirst(key);

        return map.get(key);

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
        }else {
            if(capacity==map.size()){
                int last = list.removeLast();
                map.remove(last);
            }
            list.addFirst(key);
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */