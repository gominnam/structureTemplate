package StackStructure;

import java.util.EmptyStackException;

public class Stack<T> { // generic type

    private Node<T> top;

    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    public void push(T item) {
        Node<T> t = new Node<T>(item);

        t.next = top;
        top = t;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }


}
