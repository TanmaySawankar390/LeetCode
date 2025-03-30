import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                heap.add(node.next);
            }
        }
        return dummy.next;
    }
}
