/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/15 8:16
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        SortTreeUtils.insertNode(root, 2);
        SortTreeUtils.insertNode(root, 7);
        SortTreeUtils.insertNode(root, 6);
        SortTreeUtils.insertNode(root, 8);

        AVLTreeUtils.insertNode(root,9);
        TreeTools.midOrderTraverse(root);
    }
}
