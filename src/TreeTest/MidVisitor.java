package TreeTest;

import java.util.Stack;

public class MidVisitor implements IVisitor {
    @Override
    public void visit(TreeNode node, boolean recusive) {
        if (node == null) {
            System.out.println("node数据为空，请重新输入");
            return;
        }
        if (recusive) {
            System.out.println("-----二叉树中序遍历->递归版-----");
            visitRecusivly(node);
        } else {
            System.out.println("-----二叉树中序遍历->非递归版-----");
            visitUnRecusivly(node);
        }
    }

    private void visitUnRecusivly(TreeNode node) {
        Stack<TreeNode> ts = new Stack<>();
        while (node != null || !ts.isEmpty()) {
            if (node != null) {
                ts.push(node);
                node = node.getLeft();
            }else {
                node = ts.pop();
                node.visit();
                node = node.getRight();
            }
        }

    }

    private void visitRecusivly(TreeNode node) {
        if (node.getLeft() != null) {
            visitRecusivly(node.getLeft());
        }
        node.visit();
        if (node.getRight() != null) {
            visitRecusivly(node.getRight());
        }
    }
}
