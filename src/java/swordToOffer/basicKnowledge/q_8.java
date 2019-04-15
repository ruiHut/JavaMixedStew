package swordToOffer.basicKnowledge;

public class q_8 {
    public static void main(String[] args) {
        Node node = new Node();
        Node n = getNext(node);
    }

    private static Node getNext(Node node) {
        if (node == null)
            throw new IllegalArgumentException("输入节点不能为空");

        // 输入节点有右节点，返回该右子树最左节点。
        if (node.rNode != null) {
            return getLeftMost(node);
        }
        else if (node.fNode != null) // 是否为根节点
        {
            // 输入节点无右节点
            // 输入节点为其父节点的左节点, 返回其父节点
            if (node == node.fNode.lNode) {
                return node.fNode;
            } else {
                Node f = node.fNode;
                //
                while (f.fNode != null) {
                    if (f == f.fNode.lNode) {
                        return f.fNode;
                    }
                    f = f.fNode;
                }
                return f;
            }
        }

        return null;
    }

    private static Node getLeftMost(Node node) {
        Node lMost = node.rNode;
        while (lMost.lNode != null) {
            lMost =  lMost.lNode;
        }
        return lMost;
    }
}
class Node {
    int value;
    Node fNode;
    Node lNode;
    Node rNode;
}
