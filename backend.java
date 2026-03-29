public class backend {

    // Node class (ONLY structure, no list logic)
    private class Node {
        int val;
        Node next;
    }

    // Linked List properties (must be here, NOT inside Node)
    private Node head;
    private Node tail;
    private int size;

    // Add First
    public void addfirst(int item) {
        Node nn = new Node();
        nn.val = item;

        if (size == 0) {
            head = nn;
            tail = nn;
            size++;
        } else {
            nn.next = head;
            head = nn;
            size++;
        }
    }

    // Add Last
    public void addlast(int item) {
        Node nn = new Node();
        nn.val = item;

        if (size == 0) {
            head = nn;
            tail = nn;
            size++;
        } else {
            tail.next = nn;
            tail = nn;
            size++;
        }
    }

    // Get Node
    public Node GetNode(int k) {
        if (k < 0 || k >= size) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Add at Index
    public void addatindex(int item, int k) throws Exception {
        if (k < 0 || k > size) {
            throw new Exception("Index out of bounds");
        }

        if (k == 0) {
            addfirst(item);
        } else if (k == size) {
            addlast(item);
        } else {
            Node nn = new Node();
            nn.val = item;

            Node prev = GetNode(k - 1);
            nn.next = prev.next;
            prev.next = nn;

            size++;
        }
    }

    // Get First
    public int getfirst() throws Exception {
        if (size == 0) throw new Exception("Empty list");
        return head.val;
    }

    // Get Last
    public int getlast() throws Exception {
        if (size == 0) throw new Exception("Empty list");
        return tail.val;
    }

    // Get at Index
    public int getatindex(int k) throws Exception {
        return GetNode(k).val;
    }

    // Remove First
    public int removefirst() throws Exception {
        Node temp = head;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
        }

        size--;
        return temp.val;
    }

    // Remove Last
    public int removelast() throws Exception {

        if (size == 1) {
            return removefirst();
        } else {
            Node prev = GetNode(size - 2);
            Node temp = tail;
            tail = prev;
            tail.next = null;
            size--;
        return temp.val;
        }
    }

    // Remove at Index
    public int removeatindex(int k) throws Exception {
        if (k < 0 || k >= size) {
            throw new Exception("Index out of bounds");
        }

        if (k == 0) return removefirst();
        if (k == size - 1) return removelast();

        Node prev = GetNode(k - 1);
        Node curr = prev.next;

        prev.next = curr.next;
        curr.next = null;

        size--;
        return curr.val;
    }

    // Display
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("->");
    }
}