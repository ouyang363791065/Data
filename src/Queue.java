/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/9/28 20:43
 */
public class Queue<T> {
    //队列头指针
    private Queue<T> front;

    //队列尾指针
    private Queue<T> rear;

    //存放数据
    private T data;

    //队列的实际大小
    private int size;

    //指向下一个结点的指针
    private Queue<T> next;

    //初始化一个队列
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.next = null;
        this.data = null;
    }

    //初始化一个队列，一开始就存在一个节点
    public Queue(T data) {
        this.front = this;
        this.rear = this;
        this.size = 1;
        this.next = null;
        this.data = data;
    }

    //入队列
    public void enqueue(T element) {
        Queue<T> temp = new Queue<T>();
        temp.data = element;
        if ((this.front == null) || (this.rear == null)) {
            this.rear = temp;
            this.front = temp;
        } else {
            this.rear.next = temp;
            this.rear = temp;
        }
        this.size++;
    }

    //出队列，返回出队列的值
    public T outqueue() {
        if ((this.front == null) || (this.rear == null)) {
            throw new RuntimeException("队列中一个数据都没有，请不要胡乱操作");
        } else {
            T temp = this.front.data;
            this.front = this.front.next;
            this.size--;
            return temp;
        }
    }

    //遍历，依次打印从尾巴到头的
    public void traverse() {
        Queue<T> temp = new Queue<T>();
        temp.next = this.front;
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }
}
