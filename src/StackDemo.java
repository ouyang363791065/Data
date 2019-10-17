/**
 * @Description:
 * @Author: feixi
 * @Date: 2019/10/5 15:01
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(0);
        stack.pop(1);
        stack.pop(2);
        stack.pop(3);
        stack.pop(4);

        stack.traverse();
        stack.push();
        stack.traverse();
        stack.push();
        stack.traverse();
        stack.push();
        stack.traverse();
        stack.push();
        stack.traverse();
        stack.push();
        stack.traverse();
    }
}
