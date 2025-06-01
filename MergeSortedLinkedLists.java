import java.util.*;

public class MergeSortedLinkedLists {

    // Linked List Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Build linked list from array
    private static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Merge two sorted linked lists
    private static ListNode mergeLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes
        tail.next = (a != null) ? a : b;

        return dummy.next;
    }

    // Print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to run multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {
            String[] sizes = sc.nextLine().split(" ");
            int n = Integer.parseInt(sizes[0]);
            int m = Integer.parseInt(sizes[1]);

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            String[] aElements = sc.nextLine().split(" ");
            String[] bElements = sc.nextLine().split(" ");

            for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(aElements[i]);
            for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(bElements[i]);

            ListNode list1 = buildList(arr1);
            ListNode list2 = buildList(arr2);

            ListNode merged = mergeLists(list1, list2);
            printList(merged);
        }

    }
}
