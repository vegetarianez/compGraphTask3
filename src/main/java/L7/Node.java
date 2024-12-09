package L7;

import java.util.Objects;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T value;

    public Node(T value, Node<T> next, Node<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<T> that = (Node<T>) o;
        return Objects.equals(value, that.value);
    }
}
