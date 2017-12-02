package TreeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class RootVisitor implements IVisitor {

    @Override
    public void visit(TreeNode node, boolean recusive) {
        File file = new File("D:/test.txt");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        try (FileInputStream fis = new FileInputStream("D:/test.txt"); Scanner sc = new Scanner(fis)) {
            if (recusive)
                visitRecusivly(node);
            else
                visitUnRecusivly(node);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void visitUnRecusivly(TreeNode node) {
        if (node == null) {
            System.out.println("node为空数据异常，请重新输入正常数据");
            return;
        }
        System.out.println("------二叉树的先序遍历->非递归版本-----");
        Stack<TreeNode> tns = new Stack<>();

        while (node != null || !tns.isEmpty()) {
            if (node != null) {
                node.visit();
                tns.push(node);
                node = node.getLeft();
            } else {
                node = tns.pop();
                node = node.getRight();
            }
        }
    }


    private void visitRecusivly(TreeNode node) {
        if (node == null)
            System.out.println("node为空数据异常，请重新输入正常数据");
        System.out.println("------二叉树的先序遍历->递归版本-----");
        node.visit();
        if (node.getLeft() != null)
            visitRecusivly(node.getLeft());
        if (node.getRight() != null)
            visitRecusivly(node.getRight());
    }
}
