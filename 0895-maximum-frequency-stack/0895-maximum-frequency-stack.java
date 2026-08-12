class FreqStack {
    private Map<Integer,Integer> freq;

    private Map<Integer,Stack<Integer>> mapF;

    private int maxF;

    public FreqStack() {
        freq = new HashMap<>();
        mapF = new HashMap<>();
        maxF = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        maxF = Math.max(maxF,f);

        mapF.putIfAbsent(f,new Stack<>());
        mapF.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = mapF.get(maxF);

        int val = stack.pop();
        freq.put(val,freq.get(val)-1);

        if(stack.isEmpty()){
            mapF.remove(maxF);
            maxF--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */