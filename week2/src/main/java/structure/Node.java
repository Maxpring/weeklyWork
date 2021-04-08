package structure;

import java.util.List;

/**
 * @author: zhangyk
 * @Date: 2021/4/8 15:48
 * @Description:
 * @Version: 1.0
 */
// Definition for a Node.
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
