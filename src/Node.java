/**
 * @Description: 凡是涉及位置都是使用角标，从0开始计数
 * @Author: feixi
 * @Date: 2019/9/27 12:39
 */
public class Node {
    //数据域
    private int data;

    //指向下一个结点
    private Node next;

    public int getData() {
        return data;
    }

    //构造函数传入数据域直接构造一个节点
    public Node(int data) {
        this.data = data;
    }

    //追加
    public Node append(Node node) {
        //先获取当前结点
        Node currentNode = this;
        while (currentNode.next != null) {
            //一直将当前关注的结点向链表尾部移动
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        //这里的this指向的是调用该函数的对象，比如 Node node = new Node(1); node.append(new Node(2)); 这里node调用append，所以this是node
        return this;
    }

    //在角标为col的位置后增加一个节点
    public void insert(int col, Node node) {
        //先获取当前结点
        Node currentNode = this;
        for (int i = 0; i < col; i++) {
            currentNode = currentNode.next;
        }
        node.next = currentNode.next;
        currentNode.next = node;
    }

    //删除一个角标为col的节点
    public void delete(int col) {
        //先获取当前结点
        Node currentNode = this;
        for (int i = 0; i < col - 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
    }

    //修改角标为col的结点的数据域
    public void modify(int col, int date) {
        //先获取当前结点
        Node currentNode = this;
        for (int i = 0; i < col; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = date;
    }

    //从当前节点开始遍历所有
    public void traverse() {
        //先获取当前结点
        Node currentNode = this;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    //查找指定节点的数据
    public int getNodeData(int col) {
        //先获取当前结点
        Node currentNode = this;
        for (int i = 0; i < col; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.getData();
    }
}
