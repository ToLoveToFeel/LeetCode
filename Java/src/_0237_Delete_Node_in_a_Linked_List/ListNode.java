package _0237_Delete_Node_in_a_Linked_List;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int[] arr){
        if (null == arr || 0 == arr.length)
            throw new IllegalArgumentException("array can not be empty!");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    ListNode findNode(int x){

        ListNode curNode = this;
        while(curNode != null){
            if(curNode.val == x)
                return curNode;
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ListNode cur = this;
        while(null != cur) {
            ret.append(cur.val + "->");
            cur = cur.next;
        }
        ret.append("null");

        return ret.toString();
    }
}
