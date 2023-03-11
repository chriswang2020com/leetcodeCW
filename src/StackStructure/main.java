package StackStructure;

import java.util.Stack;

/**
 * ClassName: main Package StackStructure Description Author zwang2654
 *
 * @Create 3/11/2023 3:11 AM
 * @Version 1.0
 */
public class main {
  public static void main(String[] args){
    StackStructure stack = new StackStructure(10); // 创建一个容量为10的栈
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(3);
    stack.push(3);
    stack.push(3);
    stack.push(8);
    stack.push(9);

    System.out.println(stack.pop()); // 输出3
    System.out.println(stack.peek()); // 输出2
    System.out.println(stack.size()); // 输出2
    System.out.println(stack.isEmpty()); // 输出false
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);
  }
}
