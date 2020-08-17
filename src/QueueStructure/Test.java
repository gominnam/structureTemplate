package QueueStructure;

public class Test {
    public static void main(String[] args){
        Queue<Integer> queue = new Queue<Integer>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
        System.out.println(queue.remove());
        System.out.println(queue.isEmpty());
    }
}
