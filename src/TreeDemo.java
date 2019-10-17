/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/7 21:06
 */
public class TreeDemo {
    public static void main(String[] args) {
        TreeNode<Integer> tree = new TreeNode<>(0);
        tree.addLeft(1);
        tree.addRight(2);
        tree.leftChild.addLeft(3);
        tree.leftChild.addRight(4);
        tree.leftChild.leftChild.addRight(5);

        int sum = TreeTools.getTreeNum(tree);
        System.out.println("二叉树的所有结点之和为:" + sum);
        int count = TreeTools.countAllLeafNode(tree);
        System.out.println("二叉树所有叶子结点的总和:" + count);
        int for1 = TreeTools.getNodeCountForK(tree, 1);
        int for2 = TreeTools.getNodeCountForK(tree, 2);
        int for3 = TreeTools.getNodeCountForK(tree, 3);
        int for4 = TreeTools.getNodeCountForK(tree, 4);

        System.out.println("每一层的结点数目:" + for1 + "..." + for2 + "..." + for3 + "..." + for4);

        System.out.println("二叉树的深度:" + TreeTools.getTreeDepth(tree));

        System.out.println("\n" + "先序排序");
        TreeTools.preOrderTraverse(tree);

        System.out.println("\n" + "中序排序");
        TreeTools.midOrderTraverse(tree);

        System.out.println("\n" + "先序排序");
        TreeTools.backOrderTraverse(tree);
    }
}
