/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/9/27 10:14
 */
public class LinkDemo {
    public static void main(String[] args) {
        //一定要拿一个节点当头结点
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        //当使用node2.append(node2)会使得出现死循环，因为node2对象只有一个，当一个做出改变另一个也会做出改变，即使的两份副本
        //System.out.println(node2.append(node2).append(new Node(333)).getData());

        head.append(node1).append(node3).append(node4);
        head.traverse();  //0134

        //添加
        head.insert(1, node2);
        head.traverse();  //01234

        //删除
        head.delete(1);
        head.traverse();  //0234

        //修改
        head.modify(1, 1);
        head.traverse();  //0134

        //查找
        System.out.println(head.getNodeData(1));   //1
    }
}