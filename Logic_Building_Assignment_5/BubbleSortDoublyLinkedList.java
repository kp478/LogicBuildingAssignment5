import java.util.Scanner;

class Nodes {
    int data;
    Node prev;
    Node next;

    Nodes(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class BubbleSortDoublyLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the linked list:");
        Node head = createDoublyLinkedList(scanner, n);
        scanner.close();

        System.out.println("Doubly linked list before sorting:");
        printDoublyLinkedList(head);

        head = bubbleSort(head);

        System.out.println("Doubly linked list after sorting:");
        printDoublyLinkedList(head);
    }

    public static Node createDoublyLinkedList(Scanner scanner, int n) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        return head;
    }

    public static void printDoublyLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node bubbleSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node last = null;
        boolean swapped;
        do {
            swapped = false;
            Node curr = head;
            while (curr.next != last) {
                if (curr.data > curr.next.data) {
                    swap(curr, curr.next);
                    swapped = true;
                }
                curr = curr.next;
            }
            last = curr;
        } while (swapped);
        return head;
    }

    public static void swap(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}