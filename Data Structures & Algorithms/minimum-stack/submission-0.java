class MinStack {
    class Pair{
        int val, min;
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = st.isEmpty() ? val : Math.min(val, st.peek().min);
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
