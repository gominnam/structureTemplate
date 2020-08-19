package QueueStructure;

import java.util.NoSuchElementException;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;

    // nested class
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){ // init
            this.data = data;
        }
    }

//    public void add(T item){
//        Node<T> t = new Node<T>(item);
//
//        if(last != null){
//            last.next = t;
//        }
//        last = t;
//        if(first == null){
//            first = last;
//        }
//    }

    public void add(T item){
        Node<T> n = new Node<T>(item);

        if(first == null){
            first = n;
            last = n;
        } else {
            last.next = n;
            last = n;
        }
    }

//    public T remove(){
//        if(first == null){
//            throw new NoSuchElementException();
//        }
//
//        T data = first.data;
//        first = first.next;
//
//        if(first == null){
//            last = null;
//        }
//
//        return data;
//    }

    public T remove(){
        T data;

        if(first != null){
            data = first.data;
            first = first.next;
        }else{
            throw new NoSuchElementException();
        }

        return data;
    }

    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
