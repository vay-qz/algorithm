package pers;

public class ListNodeBean {

    /**142
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fir = head;
        ListNode sec = head;
        while (sec != null) {
            fir = fir.next;
            sec = sec.next;
            if (sec == null) {
                return null;
            }
            sec = sec.next;
            if (sec == fir) {
                while (head != sec) {
                    head = head.next;
                    sec = sec.next;
                }
                return head;
            }
        }
        return null;
    }

    /**148
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return null;
    }

}
