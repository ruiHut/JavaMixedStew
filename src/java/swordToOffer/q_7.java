package swordToOffer;

public class q_7 {
    public static void main(String[] args) {
        // 构造二叉树
        BinaryTree tree = new BinaryTree(1);
        tree.setRoot(2);
        tree.addLeft(tree.getRoot(), 3);
        tree.addRight(tree.getRoot(), 4);
        tree.addLeft(tree.getRoot().rNode, 5);
        tree.addRight(tree.getRoot().rNode, 6);
        tree.addLeft(tree.getRoot().lNode, 7);
        tree.addRight(tree.getRoot().lNode, 8);
        tree.preorderTraversal(tree.getRoot());
        System.out.println();
        tree.inorderTrabersal(tree.getRoot());
        System.out.println();
        tree.postorderTrabersal(tree.getRoot());
    }
}

// 二叉树
class BinaryTree {
    private Node root;

    BinaryTree(int value) {
        root = new Node(value);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(int value) {
        root.value = value;
    }

    // 二叉树数据结构
    class Node {
        public int value;
        public Node lNode;
        public Node rNode;

        Node(int value) {
            this.value = value;
            lNode = null;
            rNode = null;
        }
    }

    public void addLeft(Node root, int value) {
        if (root == null)
            throw new IllegalArgumentException("根节点为空，无法添加 value = " + value);

        Node node = new Node(value);
        root.lNode = node;
    }

    public void addRight(Node root, int value) {
        if (root == null)
            throw new IllegalArgumentException("根节点为空，无法添加 value = " + value);

        Node node = new Node(value);
        root.rNode = node;
    }

    // 二叉树前序遍历
    // 递归
    public void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderTraversal(root.lNode);
            preorderTraversal(root.rNode);
        }
    }

    // TODO 有待补充 二叉树遍历之 循环
    public void circulationRreorderTraversal(Node root) {
        if (root == null)
            return;

        Node curNode = root;
        Node curRoot = null;
        while (curNode != null) {
            System.out.print(curNode.value + " ");
            curNode = curNode.lNode;
            curNode = curNode.rNode;
        }
    }

    // 二叉树中序遍历 递归
    public void inorderTrabersal(Node root) {
        if (root != null) {
            inorderTrabersal(root.lNode);
            System.out.print(root.value + " ");
            inorderTrabersal(root.rNode);
        }
    }

    // 二叉树后序遍历 递归
    public void postorderTrabersal(Node root) {
        if (root != null) {
            postorderTrabersal(root.lNode);
            postorderTrabersal(root.rNode);
            System.out.print(root.value + " ");
        }
    }
}