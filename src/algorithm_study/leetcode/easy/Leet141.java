package algorithm_study.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

// Linked List Cycle - https://leetcode.com/problems/linked-list-cycle/
public class Leet141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode now = head;

        while (now != null) {
            if (!set.add(now)) {
                return true;
            }

            if (now.next == null) {
                break;
            }
            now = now.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

