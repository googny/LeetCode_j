package twopointers.easy;

/**
 * Given a linked list, remove the Nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * @author googny
 * @since 2015/6/15
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode curse = head;
        for (int i = 2; i <= 10; i++) {
            ListNode node = new ListNode(i);
            node.next = null;
            curse.next = node;
            curse = node;
        }

        ListNode he = new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 1);
        while (he != null) {
            System.out.print(he.val + " ");
            he = he.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode top = head;
        ListNode back = head;
        ListNode preBack = head;
        for (int i = 0; i < n; i++) {
            top = top.next;
        }
        if (top == null) {
            return head.next;
        }
        while (top != null) {
            preBack = back;
            back = back.next;
            top = top.next;
        }
        preBack.next = back.next;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
