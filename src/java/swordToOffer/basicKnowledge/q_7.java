package swordToOffer.basicKnowledge;

import java.util.Stack;

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

    // TODO 有待具体实现
    // preorders 前序结果， inorders 中序结果
    public BinaryTree rebackBinaryTree(int[] preorders, int[] inorders) {
        if (preorders.length == 0 && inorders.length == 0)
            return null;

        Node root = new Node(preorders[0]);
        root.lNode = rebackBinaryTree(preorders, inorders).getRoot();
        root.rNode = rebackBinaryTree(preorders, inorders).getRoot();

        return BinaryTree.this;

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

    // 非递归实现 1. 使用栈保存数据 2. 终止条件对应修改
    public void circulationRreorderTraversal(Node root) {
        if (root == null)
            return;

        Stack s = new Stack();
        Node curNode = root;

        while (curNode != null || !s.empty()) {
            // 找到最左节点，结束循环
            while (curNode!= null) {
                System.out.print(curNode.value + " ");
                s.push(curNode);
                curNode = curNode.lNode;
            }

            // 左节点全部遍历完成，弹出将该节点，游标改到弹出节点的右节点
            if (!s.empty()) {
                curNode = (Node) s.pop();
                curNode = curNode.rNode;
            }
        }
    }

    // 二叉树中序遍历
    // 递归
    public void inorderTrabersal(Node root) {
        if (root != null) {
            inorderTrabersal(root.lNode);
            System.out.print(root.value + " ");
            inorderTrabersal(root.rNode);
        }
    }

    // 循环
    public void circulationInorderTrabersal(Node root) {
        if (root == null)
            return;

        Stack s = new Stack();
        Node curNode = root;

        while (curNode != null || !s.empty()) {
            // 找到最左节点，结束循环
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.lNode;
            }

            // 当栈还有元素，移动游标到该节点兄弟节点即其右节点
            if(!s.empty()) {
                curNode = (Node) s.pop();
                System.out.print(curNode.value + " ");
                curNode = curNode.rNode;
            }

        }

    }
    // 二叉树后序遍历
    // 递归
    public void postorderTrabersal(Node root) {
        if (root != null) {
            postorderTrabersal(root.lNode);
            postorderTrabersal(root.rNode);
            System.out.print(root.value + " ");
        }
    }

    // 循环
    // 后序遍历在决定是否可以输出当前节点值时，需要考虑其左右子树是否都已经遍历完成
    public void circulationPostorderTrabersal(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack();
        Node curNode = root;
        Node lastVisit = root;

        while (curNode != null || !s.empty()) {
            // 找到最左子树
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.lNode;
            }

            // 左子树节点以为空，返回其父亲节点，即二叉树的中节点
            curNode = s.peek();
            // 后续继续判断其右子树
            // 若又右子树，且没访问过其右子树，调整游标
            // 若无右子树，或其右子树以访问完毕，输出该节点 调整游标
            if (curNode.rNode == null || curNode.rNode == lastVisit) {
                System.out.print(curNode.value + " ");
                curNode = s.pop();
                lastVisit = curNode;
                curNode = null;
            } else
                curNode = curNode.rNode;
        }
    }
}

//        for (int i = 0; i < inorders.length; i++) {
//        if (inorders[i] == root) {
//        leftTree = false;
//        continue;
//        }
//
//        if (leftTree) {
//        lTrees.add(inorders[i]);
//        } else {
//        rTrees.add(inorders[i]);
//        }
//        }
//
//        int lTreesSize = lTrees.size();
//        int rTreesSize = rTrees.size();
//
//        return new BinaryTree(1);