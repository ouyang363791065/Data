/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/7 13:31
 */
public class TreeTools {
    /**
     * 计算二叉树的深度
     * 递归计算深度思路：深度等于根节点的子树深度+1，一直递归到深度为0即可。
     */
    public static <T> int getTreeDepth(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.leftChild) + 1;
        int rigDepth = getTreeDepth(root.rightChild) + 1;
        return Math.max(leftDepth, rigDepth);
    }

    //访问本结点
    private static <T> void visitNode(TreeNode<T> node) {
        System.out.print(node.value + "\t");
    }

    //前序遍历--根左右
    public static <T> void preOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        visitNode(root);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    //中序排序--左根右
    public static <T> void midOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        midOrderTraverse(root.leftChild);
        visitNode(root);
        midOrderTraverse(root.rightChild);
    }

    //后序排序--左右根
    public static <T> void backOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        backOrderTraverse(root.leftChild);
        backOrderTraverse(root.rightChild);
        visitNode(root);
    }

    /**
     * 获取第k层的结点个数
     *
     * @param root
     * @param k
     * @param <T>
     */
    public static <T> int getNodeCountForK(TreeNode<T> root, int k) {
        //当父节点为空，不能算上，k<1是排除刚传进来的异常情况
        if (k < 1 || root == null) {
            return 0;
        }
        //递归的条件，因为在k==1的时候就是当递归达到指定层数的时候进行计数操作
        if (k == 1) {
            return 1;
        }
        //这里的设计很巧妙，当k==1的时候就到了我们想要到的层，到了该层就返回1，然后左边计数和右边计数相加通过函数返回值计算总的结点数
        int leftCount = getNodeCountForK(root.leftChild, k - 1);
        int rightCount = getNodeCountForK(root.rightChild, k - 1);
        return leftCount + rightCount;
    }

    //统计二叉树所有节点的数量
    public static <T> int getTreeNum(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return getTreeNum(root.leftChild) + getTreeNum(root.rightChild) + 1;
    }

    /**
     * 计算二叉树的所有叶子结点的个数(没有左孩子、右孩子的结点)
     *
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int countAllLeafNode(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }
        int left = countAllLeafNode(root.leftChild);
        int right = countAllLeafNode(root.rightChild);
        return left + right;
    }
}
