import java.util.Scanner;

class Stack {
    private int maxSize;
    private int[] stack; // 使用 数组存储数据
    private int top = -1; // 栈空时为 -1，非空时为该入栈位置索引

    // 构造器
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize]; // 大小为 maxSize 的 int数组
    }

    // 返回当前栈顶值的 方法
    int peek(){
        return stack[top];
    }

    // 判断栈是否空
    boolean isEmpty() {
        return top == -1; // top == -1 即为 栈空
    }

    // 判断栈是否满
    boolean isFull() {
        return top == maxSize - 1; // 此为 栈满 条件
    }

    // 入栈操作 push
    void push(int val){
        if(isFull()){
            System.out.println("栈已满~~");
            return; // 直接返回
        }
        top++; // 这是栈未满的加入逻辑
        stack[top] = val;
        // stack[++top] = val; 也可以
    }

    // 出栈 pop , 返回栈顶数据
    int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 判断 元素 是否在 栈中
    private boolean isExist(int element){
        if(isEmpty()){
            System.out.println("栈空无元素");
            return false;
        }
        // 从栈顶 开始 查询数据
        for (int i = top; i >= 0;i--){
            if(element == stack[i]) return true;
        }
        return false;
    }
}
class ExecChange {
    /**
     * 十进制转为二进制、八进制、十六进制打印输出
     * num 为 待转换 的值 ，target 为转换进制
     *   方法： 第一位（最小位） 要 用 num % target ；
     *   之后的 位  依次 num / target 然后 % target
     *
     */

    private int num;
    private int target;

    // 初始化 栈（大小随意，够用就行）
    Stack stack = new Stack(100000000);
    // 构造器
    public ExecChange(int num, int target) {
        this.num = num;
        this.target = target;
    }

    public void changeNum(int num, int target){
        if(num==0){  // 判断 num 是否为零， 0 的任何 进制均为 0
            System.out.println(0);
        } else{
            while(num!=0){
                stack.push(num%target); // 计算结果 入栈
                num/=target;
            }
            while (!stack.isEmpty()) { // 不是空栈 就输出
                if(stack.peek()==10) { // 这里 处理 16进制 问题（还待 优化）
                    System.out.print("A");
                    int a = stack.pop(); // 这里意思是 弹出栈顶元素
                }else if(stack.peek()==11){// peek() 方法 只获取 栈顶值 但不弹出
                    System.out.print("B");
                    int a = stack.pop();
                }else if(stack.peek()==12){
                    System.out.print("C");
                    int a = stack.pop();
                }else if(stack.peek()==13){
                    System.out.print("D");
                    int a = stack.pop();
                }else if(stack.peek()==14){
                    System.out.print("E");
                    int a = stack.pop();
                }else if (stack.peek()==15){
                    System.out.print("F");
                    int a = stack.pop();
                }else{
                    System.out.print(stack.pop());
                }
            }
        }
    }
}

public class TwiceTest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("在此输入待转换数字 ：");
        int num = scanner.nextInt();
        System.out.println("请输入想要转换的进制(2/4/8/16) ：");
        int target = scanner.nextInt();
        System.out.println("转换结果如下： ");
        ExecChange execChange = new ExecChange(num, target);
        execChange.changeNum(num,target);
    }

}
