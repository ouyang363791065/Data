/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/9/29 17:56
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("what");
        queue.enqueue("are");
        queue.enqueue("you");
        queue.enqueue("doing");
        queue.enqueue("?");
        queue.traverse();

        System.out.println(queue.outqueue());
        System.out.println(queue.outqueue());
        System.out.println(queue.outqueue());
        System.out.println(queue.outqueue());
        System.out.println(queue.outqueue());
        queue.traverse();
    }
}
