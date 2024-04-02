package ProblemsLeetCode;

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode margedList = new ListNode();
        ListNode tempMargedList = margedList;

        if (list1 != null) {
            margedList = list1;
            while (list1 != null) {
                if (list2 != null) {
                    if (list1.val < list2.val) {
                        margedList.next = list1;
                        list1 = list1.next;
                    }
                    else {
                        margedList.next = list2;
                        list2 = list2.next;
                    }
                }
            }
        }

        return margedList;
    }
}