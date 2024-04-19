import java.util.Scanner;

class Node {
    public Node prev;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BubbleSortLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements of the linked list:");
        Node head = createLinkedList(scanner, n);
        scanner.close();

        System.out.println("Linked list before sorting:");
        printLinkedList(head);

        head = bubbleSort(head);

        System.out.println("Linked list after sorting:");
        printLinkedList(head);
    }

    public static Node createLinkedList(Scanner scanner, int n) {
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
                tail = newNode;
            }
        }
        return head;
    }

    public static void printLinkedList(Node head) {
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
        Node dummy = new Node(0);
        dummy.next = head;
        boolean swapped;
        do {
            swapped = false;
            Node prev = dummy;
            Node curr = dummy.next;
            Node next = curr.next;
            while (next != null) {
                if (curr.data > next.data) {
                    curr.next = next.next;
                    next.next = curr;
                    prev.next = next;
                    swapped = true;
                }
                prev = curr;
                curr = next;
                next = next.next;
            }
        } while (swapped);
        return dummy.next;
    }
}
