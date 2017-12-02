package TreeTest;

public class Client {
    public static void main(String[] args) {
//        IVisitor visitor = new RootVisitor();
//        IVisitor visitor = new MidVisitor();
        IVisitor visitor = new BackVisitor();
        TreeNode node = createNode();
        visitor.visit(node, true);
        visitor.visit(node, false);

    }

    private static TreeNode createNode() {
        TreeNode node4 = new TreeNode("D", null, null);
        TreeNode node5 = new TreeNode("E", null, null);
        TreeNode node6 = new TreeNode("F", null, null);
        TreeNode node7 = new TreeNode("G", null, null);
        TreeNode node2 = new TreeNode("B", node4, node5);
        TreeNode node3 = new TreeNode("C", node6, node7);
        TreeNode node1 = new TreeNode("A", node2, node3);
        return node1;
    }
}
