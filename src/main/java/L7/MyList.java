package L7;

import java.util.Iterator;

public class MyList<T> implements MyListInterface<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    public void add(T value){
        Node<T> node = new Node<>(value, null, null);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
    }

    public Node<T> delete(){
        if (head == null) {
            return null;
        }

        Node<T> node = tail;
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return node;
    }
    public Node<T> delete(T value) {
        Node<T> curr = head;

        while (curr != null) {
            if (curr.getValue().equals(value)) {

                if (curr.getPrevious() != null) {
                    curr.getPrevious().setNext(curr.getNext());
                } else {
                    head = curr.getNext();
                }

                if (curr.getNext() != null) {
                    curr.getNext().setPrevious(curr.getPrevious());
                } else {
                    tail = curr.getPrevious(); // Если удаляем хвост, обновляем хвост
                }
                size--;


            }
            curr = curr.getNext();
        }
        return null;
    }

    public Node<T> findByValue(T value) {
        if (getHead().getValue().equals(value)) {
            return getHead();
        }
        for (Iterator<Node<T>> i = iterator(); i.hasNext();) {
            Node<T> node = i.next();
            if (node.getValue().equals(value)) {
                return node;
            }
        }
        return null;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MyList<T> next() {
        return null;
    }
    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {
            private Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr.getNext() != null;
            }

            @Override
            public Node<T> next() {
                curr = curr.getNext();
                return curr;
            }
        };
    }

}
