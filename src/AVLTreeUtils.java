/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/14 12:39
 */
public class AVLTreeUtils {
    /**
     * 向排序二叉树增加一个结点
     *
     * @param root
     * @param data
     */
    public static void insertNode(TreeNode<Integer> root, Integer data) {
        TreeNode<Integer> temp = root;
        TreeNode<Integer> current;
        //找到要插入的地方
        while (true) {
            //保存父节点
            current = temp;
            if (data > temp.value) {
                temp = temp.rightChild;
                //插入结点
                if (temp == null) {
                    current.addRight(data);
                    break;
                }
            } else {
                temp = temp.leftChild;
                //插入结点
                if (temp == null) {
                    current.addLeft(data);
                    break;
                }
            }
        }
        //当平衡因子大于等于2，也就是左子树比右子树高的话，需要进行右旋转
        if (getBalanceFactor(root) >= 2) {
            if (TreeTools.getTreeDepth(root.leftChild) < TreeTools.getTreeDepth(root.leftChild)) {
                //左旋转后变成只需要右旋转的情况然后进行右旋转
                leftRotate(root.leftChild);
                rightRotate(root);
            } else {
                //进行右旋转
                rightRotate(root);
            }
        }
        //当平衡因子小于等于-2，也就是右子树比左子树高的话，需要进行左旋转
        if (getBalanceFactor(root) <= -2) {
            if (TreeTools.getTreeDepth(root.leftChild) < TreeTools.getTreeDepth(root.leftChild)) {
                //右旋转后变成只需要左旋转的情况然后进行左旋转
                rightRotate(root.rightChild);
                leftRotate(root);
            } else {
                //进行右旋转
                leftRotate(root);
            }
        }
    }

    //AVL进行左旋转
    private static void leftRotate(TreeNode<Integer> root) {
        //创建一个新的结点，值等于当前结点的值
        TreeNode<Integer> node = new TreeNode<>(root.value);
        //将新结点的左子树设置为当前结点的左子树
        node.leftChild = root.leftChild;
        //将新节点的右子树设置成当前结点的右子树的左子树
        node.rightChild = root.rightChild.leftChild;
        //把当前结点的值设置成当前结点的右节点的值
        root.value = root.rightChild.value;
        //让当前节点的右子节点成为根节点
        root.rightChild = root.rightChild.rightChild;
        //让新节点成为根节点的左子树
        root.leftChild = node;
    }

    //AVL进行右旋转
    private static void rightRotate(TreeNode<Integer> root) {
        //创建一个新的结点，值等于当前结点的值
        TreeNode<Integer> node = new TreeNode<>(root.value);
        //将新结点的右子树设置为当前结点的右子树
        node.rightChild = root.rightChild;
        //将新节点的左子树设置成当前结点的左子树的右子树
        node.leftChild = root.leftChild.rightChild;
        //把当前结点的值设置成当前结点的左节点的值
        root.value = root.leftChild.value;
        //让当前节点的左子节点成为根节点
        root.leftChild = root.leftChild.leftChild;
        //让新节点成为根节点的右子树
        root.rightChild = node;
    }

    //获取一个节点的平衡因子
    public static int getBalanceFactor(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        //等于左子树的深度和右子树之差的绝对值
        int left = TreeTools.getTreeDepth(root.leftChild) + 1;
        int right = TreeTools.getTreeDepth(root.rightChild) + 1;
        return left - right;
    }

    /**
     * 排序二叉书的查找:先从根节点开始找，如果小去左子树找，进行递归查找，大的从右子树找，相同方法。
     *
     * @param root
     * @param data
     */
    public static void findNode(TreeNode<Integer> root, Integer data) {
        if (root == null) {
            System.out.println("没有找到");
            return;
        }
        if (root.value.equals(data)) {
            System.out.println("查询成功");
            return;
        }
        if (root.value.compareTo(data) > 0) {
            findNode(root.leftChild, data);
        } else {
            findNode(root.rightChild, data);
        }
    }

    /**
     * 查询最大值
     *
     * @param root
     */
    public static int getMax(TreeNode<Integer> root) {
        if (root == null) {
            throw new RuntimeException("无节点存在异常");
        }
        if (root.rightChild == null) {
            return root.value;
        }
        return getMax(root.rightChild);
    }

    /**
     * 查询最小值
     *
     * @param root
     */
    public static int getMin(TreeNode<Integer> root) {
        if (root == null) {
            throw new RuntimeException("无节点存在异常");
        }
        if (root.leftChild == null) {
            return root.value;
        }
        return getMin(root.leftChild);
    }
}
