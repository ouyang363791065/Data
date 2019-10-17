/**
 * @Description: 二叉树
 * @Author: feixi
 * @Date: 2019/10/7 12:43
 */
public class TreeNode<T> {
    //数据域
    T value;
    //左子树
    TreeNode<T> leftChild;
    //右子树
    TreeNode<T> rightChild;

    //有参构造
    public TreeNode(T value) {
        this.value = value;
    }

    //无参构造
    public TreeNode() {
    }

    //增加左子节点
    public void addLeft(T value) {
        TreeNode<T> leftChild = new TreeNode<T>(value);
        this.leftChild = leftChild;
    }

    //增加右子节点
    public void addRight(T value) {
        TreeNode<T> rightChild = new TreeNode<T>(value);
        this.rightChild = rightChild;
    }
}
