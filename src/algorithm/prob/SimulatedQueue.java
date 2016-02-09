package algorithm.prob;
public class SimulatedQueue<E> {
    private java.util.Stack<E> stack = new java.util.Stack<E>();

    public void insert(E elem) {
        if (!stack.empty()) {
            E topElem = stack.pop();
            insert(elem);
            stack.push(topElem);
        }
        else
            stack.push(elem);
    }

    public E remove() {
        return stack.pop();
    }
}