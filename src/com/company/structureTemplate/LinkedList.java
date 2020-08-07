package com.company.structureTemplate;

// Master 브런치에서의 Node 클래스는 헤더를 삭제할 수 없지만 LinkedList는 헤더가 있으므로 삭제할 수 있다.
class LinkedList {
    Node header;

    // 삭제할 노드 위치의 정보 갖고오는 매서드
    public Node get(int n) {
        int count = 0;
        Node node = this.header;

        while(count != n){
            count ++;
            node = node.next;
        }

        return node;
    }

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

    // 단점은 처음과 끝은 지우지 못한다.
    private static boolean deleteNode(Node n){
        if(n == null || n.next == null){
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;

        return true;
    }

    public static class LinkedListCountBackwards {
        public static void main(String[] args) {
            LinkedList li = new LinkedList();
            li.append(1);
            li.append(4);
            li.append(2);
            li.append(3);
            li.retrieve();

            deleteNode(li.get(2));
            li.retrieve();
        }
    }

}





