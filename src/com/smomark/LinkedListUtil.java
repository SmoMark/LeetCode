package com.smomark;

public class LinkedListUtil {

    public static void printListNode(final ListNode l) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode lT = l;
        while (lT != null) {
            stringBuilder.append(lT.val).append(", ");
            lT = lT.next;
        }
        System.out.println(stringBuilder.toString());
    }
}
