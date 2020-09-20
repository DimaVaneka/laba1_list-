package Task1;

public class Node<Value> {
    private Value data;
    private Node<Value> next;
    private Node<Value> previous;

    public Node(Value data, Node<Value> next, Node<Value> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Value getData() {
        return data;
    }

    public void setData(Value data) {
        this.data = data;
    }

    public Node<Value> getNext() {
        return next;
    }

    public void setNext(Node<Value> next) {
        this.next = next;
    }

    public Node<Value> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<Value> previous) {
        this.previous = previous;
    }
}