package leetcode.editor.cn.structure;

/**
 * @author zhangyk
 * @Since 2021/6/30
 */


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
