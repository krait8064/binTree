package TreeTest;

import java.util.Stack;

public class BackVisitor implements IVisitor {

    @Override
    public void visit(TreeNode node, boolean recusive) {
        if (node == null) {
            System.out.println("node error");
            return;
        }
        if (recusive) {
            System.out.println("------二叉树后序遍历递归版-----");
            visitRecusivly(node);
        } else {
            System.out.println("------二叉树后序遍历非递归版-----");
            visitUnRecusivly(node);
        }

    }

    private void visitUnRecusivly(TreeNode node) {
        Stack<TreeNode> ts = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        while (node != null || !ts.isEmpty()) {
            if (node != null) {
                ts.push(node);
                out.push(node);
                node = node.getRight();
            } else {
                node = ts.pop();
                node = node.getLeft();
            }
        }
        while (!out.isEmpty()) {
            out.pop().visit();
        }
    }

    private void visitRecusivly(TreeNode node) {
        if (node.getLeft() != null)
            visitRecusivly(node.getLeft());
        if (node.getRight() != null)
            visitRecusivly(node.getRight());
        node.visit();
    }

}
