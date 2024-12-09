package L7;

import java.util.Iterator;

public interface MyListInterface<T> extends Iterator<MyList<T>> {
    void add(T value);

    Node<T> delete();

    @Override
    boolean hasNext();

    @Override
    MyList<T> next();

    Iterator<Node<T>> iterator();
}
