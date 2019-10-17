/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/8 15:29
 */
public class SortTreeDemo {
    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(3);
        SortTreeUtils.insertNode(root, 15);
        SortTreeUtils.insertNode(root, 20);
        SortTreeUtils.insertNode(root, 40);
        SortTreeUtils.insertNode(root, 35);
        SortTreeUtils.insertNode(root, 10);
        SortTreeUtils.insertNode(root, 50);
        SortTreeUtils.insertNode(root, 30);

        TreeTools.midOrderTraverse(root);
        System.out.println();

        SortTreeUtils.deleteNode(root,40);
        TreeTools.midOrderTraverse(root);
        System.out.println();
    }
}
