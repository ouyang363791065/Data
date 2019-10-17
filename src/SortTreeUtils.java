/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/8 15:07
 */
public class SortTreeUtils {
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

    /**
     * 删除二叉树的一个节点，有三种请款
     * 1. 该节点为叶子结点
     * 2. 该节点只有一棵子树
     * 3. 该节点有左子树和右子树
     *
     * @param root
     * @param data
     */
    public static TreeNode<Integer> deleteNode(TreeNode<Integer> root, Integer data) {
        if (root == null) {
            throw new RuntimeException("未找到该节点");
        }
        //递归找到要删除的结点
        if (data > root.value) {
            //如果大于根节点的值，就去右子树删除这个节点，并且假如右结点就是要删除的元素，就将父节点的右孩子指向右孩子的右孩子---大问题化成小问题
            root.rightChild = deleteNode(root.rightChild, data);
            return root;
        } else if (data < root.value) {
            //如果小于根节点的值，就去左子树删除这个节点，并且假如左结点就是要删除的元素，就将父节点的左孩子指向左孩子的左孩子---大问题化成小问题
            root.leftChild =  deleteNode(root.leftChild, data);
            return root;
        } else {
            if (root.leftChild != null && root.rightChild != null) {
                /**
                 * 当左右子树都不为空的时候，将这种情况化为只有单个节点的情况
                 * 当要删除的结点有两棵子树的时候，有两种解决办法
                 * 1. 去找该节点的左子树最大的值与要删除结点替换，然后删除替换后的该节点(此时删除这个节点就是删除一个只有一棵子树的结点)
                 * 2. 去找该节点的右子树最小的值与要删除结点替换，然后删除替换后的该节点(此时删除这个节点就是删除一个只有一棵子树的结点)
                 */
                int min = getMin(root.rightChild);
                root.value = min;
                //删除右子树中，替换后而且value是min的结点，并且假如右结点就是要删除的元素，就将父节点的右孩子指向右孩子的右孩子
                root.rightChild =  deleteNode(root.rightChild, min);
                return root;
            } else {
                //当只有左子树的情况
                if (root.leftChild != null) {
                    //在这里为了让父节点指向左孩子的左孩子
                    return root.leftChild;
                } else {
                    //当只有右子树的情况，或者无子树的情况
                    return root.rightChild;
                }
            }
        }
    }
}
