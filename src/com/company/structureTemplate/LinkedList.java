package com.company.structureTemplate;

// Master 브런치에서의 Node 클래스는 헤더를 삭제할 수 없지만 LinkedList는 헤더가 있으므로 삭제할 수 있다.
class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    // 링크드리스트 생성
    LinkedList() {
        header = new Node();
    }

    // 노드 추가
    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // 노드 삭제
    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    // 노드 출력
    void retrieve() {
        Node n = header.next;
        // 마지막 node 전까지의 data들을 출
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        // 마지막 node.data 프린트
        System.out.println(n.data);
    }

    // 중복 숫자 제거
    void removeDups() {
        Node n = header;
        while (n != null) { // n.next 는 error
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    // ------------------------ here count backward methods
    // backwardCount Basic method way:1
    private static Node KthToLast(Node first, int k){ // first에 header
        Node n = first;
        int total = 1;
        while(n.next != null){
            total++;
            n = n.next;
        }

        n = first;
        for(int i = 1; i < total - k + 1; i++){
            n = n.next;
        }
        return n;
    }

    // JAVA는 pass by reference가 안되므로 객체를 스택에 넣어 그 값을 이용하는 방식으로 사용한다.
    static class Reference{
        public int count;
    }

    // backwardCount Basic method way:2
    private static Node KthToLast2(Node n, int k, Reference r){
        if(n == null){
            return null;
        }

        Node found = KthToLast2(n.next, k, r);
        r.count++;
        if(r.count == k){
            return n;
        }
        return found;
    }

    // backwardCount Basic method way:3
    private static Node KthToLast3(Node first, int k){
        Node p1 = first;
        Node p2 = first;

        for(int i = 0; i < k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static class LinkedListCountBackwards {
        public static void main(String[] args) {
            LinkedList li = new LinkedList();
            li.append(1);
            li.append(4);
            li.append(2);
            li.append(3);
            li.retrieve();

//            방법 3
//            int k = 3;
//            Node found = KthToLast3(li.header, k);
//            System.out.println(found.data);

//            방법 2
//            int k = 3;
//            Reference r = new Reference();
//            Node found = KthToLast2(li.header, k, r);
//            System.out.println(found.data);


//            방법 1
            Node first = li.header;
            int k = 4;
            Node kth = KthToLast(first, k);
            System.out.println("Last K(" + k + ")th data is " + kth.data);
        }
    }
}





