package pers;

/**
 * @author qiaozhe
 * @date 2022/2/23
 */
public class LinkedListBean {

    /**206 链表反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
