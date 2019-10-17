/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/5 14:17
 */
public class Stack<T> {
    //数据域
    private T data;
    //栈顶指针
    private Stack<T> top;
    //栈底指针
    private Stack<T> bottom;
    //指向下一个结点的指针
    private Stack<T> next;
    //栈中存在多少元素
    private int size;

    //初始化栈
    public Stack(T data) {
        this.data = data;
        this.top = this;
        this.bottom = this;
        this.next = null;
        this.size = 1;
    }

    //入栈
    public void pop(T data) {
        Stack<T> stack = new Stack<>(data);
        stack.next = this.top;
        this.top = stack;
        this.size++;
    }

    //出栈
    public T push() {
        if (this.size == 0) {
            throw new RuntimeException("栈中已经没有数据了");
        } else {
            T temp = this.top.data;
            this.top = this.top.next;
            this.size--;
            return temp;
        }
    }

    //遍历--从栈顶到栈底
    public void traverse() {
        if (this.size == 0) {
            throw new RuntimeException("栈中无数据");
        } else {
            Stack<T> temp = new Stack<T>(null);
            temp = this.top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
